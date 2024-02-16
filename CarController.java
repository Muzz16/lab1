import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    protected ArrayList<Car> cars = new ArrayList<>();
    protected CarWorkshop<Volvo240> volvoWorkshop = new CarWorkshop<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        Car v0 = new Volvo240();
        v0.setY(50);
        v0.setX(0);
        cc.cars.add(v0);

        Car v1 = new Saab95();
        v1.setY(150);
        v1.setX(0);
        cc.cars.add(v1);

        Car v2 = new Scania();
        v2.setY(250);
        v2.setX(0);
        cc.cars.add(v2);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                frame.drawPanel.moveit(car,x, y);
                if(x > frame.drawPanel.getWidth()-115){
                    car.setDirection(Directions.WEST);
                }
                if(x < 0){
                    car.setDirection(Directions.EAST);
                }
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();

                if(car instanceof Volvo240){
                    if(car.getX() >= frame.drawPanel.volvoWorkshopPoint.x && car.getX() < frame.drawPanel.volvoWorkshopPoint.x+10){
                        car.currentSpeed = 0;
                        if(!volvoWorkshop.contains((Volvo240) car)) {
                            volvoWorkshop.add((Volvo240) car);
                        }
                    }
                    else{
                        if(volvoWorkshop.contains((Volvo240) car)){
                            volvoWorkshop.removeCar();
                        }
                    }

                }

            }

        }
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

}
