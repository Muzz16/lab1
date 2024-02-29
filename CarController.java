import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController extends JFrame{

    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.

    // The frame that represents this instance View of the MVC pattern
    // A list of cars, modify if needed
    DrawPanel drawPanel;
    Random rand = new Random(3);
    Random randY = new Random();

    protected static final int X = 1000;
    protected static final int Y = 800;

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");

    JButton AddCarButton = new JButton("Add Car");
    JButton RemoveCarButton = new JButton("Remove Car");
    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");
    JPanel controlPanel = new JPanel();
    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    JLabel gasLabel = new JLabel("Amount of gas");

    protected ArrayList<Car> cars = new ArrayList<>();
    protected CarWorkshop<Volvo240> volvoWorkshop = new CarWorkshop<>();
    int gasAmount = 0;

    public void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.add(drawPanel);


        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.add(AddCarButton, 6);
        controlPanel.add(RemoveCarButton, 7);
        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.green);
        startButton.setForeground(Color.black);
        startButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/5-15,200));
        this.add(stopButton);


        // This actionListener is for the gas button only
        // TODO: Create more for each component as necessary
        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gas(gasAmount);
            }
        });

        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brake(gasAmount);
            }
        });

        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turboOn();
            }
        });

        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turboOff();
            }
        });

        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liftBed();
            }
        });

        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lowerBed();
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stop();
            }
        });

        AddCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCar();
            }
        });

        RemoveCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeCar();
            }
        });



        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }
    }

    void brake(int amount){
        double brake = ((double) amount) / 100;
        for(Car car : cars){
            car.brake(brake);
        }
    }

    void turboOn(){
        for(Car car : cars){
            if(car instanceof Saab95){
                car.setTurboOn();
            }
        }
    }
    void turboOff(){
        for(Car car : cars){
            if(car instanceof Saab95){
                car.setTurboOff();
            }
        }
    }

    void liftBed(){
        for(Car car : cars){
            if(car instanceof Scania){
                car.increaseAngle(10);
            }
        }
    }

    void lowerBed(){
        for(Car car : cars){
            if(car instanceof Scania){
                car.decreaseAngle(10);
            }
        }
    }

    void start(){
        for(Car car : cars){
            if(!(car.currentSpeed > 0)) {
                car.startEngine();
            }
            else throw new IllegalArgumentException("Engine is already on");
        }
    }

    void stop(){
        for(Car car : cars){
            car.stopEngine();
        }
    }

    void addCar() {
        Car volvo = CarFactory.createVolvo240();
        Car saab = CarFactory.createSaab95();
        Car scania = CarFactory.createScania();
        Car[] possibleCars = new Car[]{volvo, saab, scania};

        if (cars.size() < 10) {
            Car newCar = possibleCars[rand.nextInt(3)];
            int randomYpos = randY.nextInt(450);
            newCar.setY(randomYpos);
            cars.add(newCar);
            newCar.startEngine();

            drawPanel.updateCars(cars);
            newCar.addObserver(drawPanel);
            cars.add(newCar);

        } else {
            throw new IllegalArgumentException("Too many cars, full");
        }
    }

    void removeCar(){
        if(cars.size() > 0){
            Car removedcar = cars.remove(0);
            drawPanel.gc.carPositions.remove(removedcar);
            drawPanel.gc.carImages.remove(removedcar);
        }
        else throw new IllegalArgumentException("There are no cars");
        }
    }


