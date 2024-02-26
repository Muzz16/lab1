import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarBrain {
    private final int delay = 50;
    protected Timer timer = new Timer(delay, new TimerListener());
    CarController cc = new CarController();
    CarView frame;
    public static void main(String[] args) {
        new CarBrain().startProgram();
    }

    public void startProgram(){

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
        frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        timer.start();
    }
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cc.cars) {
                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                cc.drawPanel.moveit(car,x, y);
                if(x > cc.drawPanel.getWidth()-115){
                    car.setDirection(Directions.WEST);
                }
                if(x < 0){
                    car.setDirection(Directions.EAST);
                }
                // repaint() calls the paintComponent method of the panel
                cc.drawPanel.repaint();

                if(car instanceof Volvo240){
                    if(car.getX() >= cc.drawPanel.gf.volvoWorkshopPoint.x && car.getX() < cc.drawPanel.gf.volvoWorkshopPoint.x+10){
                        car.currentSpeed = 0;
                        if(!cc.volvoWorkshop.contains((Volvo240) car)) {
                            cc.volvoWorkshop.add((Volvo240) car);
                        }
                    }
                    else{
                        if(cc.volvoWorkshop.contains((Volvo240) car)){
                            cc.volvoWorkshop.removeCar();
                        }
                    }
                }
            }
        }
    }

}