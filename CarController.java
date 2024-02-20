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

    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.

    // The frame that represents this instance View of the MVC pattern
    // A list of cars, modify if needed
    CarView frame;
    protected ArrayList<Car> cars = new ArrayList<>();
    protected CarWorkshop<Volvo240> volvoWorkshop = new CarWorkshop<>();

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
