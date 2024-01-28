import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CarTransport extends Car {
    private boolean rampIsUp;
    private Deque<Car> carsLoaded = new ArrayDeque<>();

    public CarTransport(int i, int i1, String långtradare, Color color) {
        super(i,i1,långtradare,color);
    }

    @Override
    public double speedFactor(){
        return 0;
    }

    @Override
    public void incrementSpeed(double amount) {
        if(canMove()) {
            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
        }
        else throw new IllegalArgumentException("Can't move truck, ramp angle > 0");
    }

    @Override
    public void decrementSpeed(double amount) {
        if(canMove()) {
            currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
        }
        else throw new IllegalArgumentException("Can't move truck, ramp angle > 0");
    }

    public void rampSwitch(){
        if(rampIsUp == true && notMoving()){
            rampIsUp = false;
        }
        else rampIsUp = true;
    }

    public boolean notMoving(){
        if(currentSpeed == 0){
            return true;
        }
        return false;
    }

    public boolean CarisClose(Car car){
        if(car.getX() >= (getX()-5) && car.getY() == getY()){
            return true;
        }
        return false;
    }

    public boolean CarIsNotCarTransport (Car car){
        if(car instanceof CarTransport){
            return false;
        }
        else return true;
    }

    public void loadCars(Car car){
        if(!rampIsUp && CarisClose(car) && CarIsNotCarTransport(car)){
            carsLoaded.push(car);
            car.setX(getX());
            car.setY(getY());
        }
        else throw new IllegalArgumentException("Can't load car because car is too far away or ramp is up");
    }

    public void unloadCars(Car car){
        if(rampIsUp == false){
            carsLoaded.pop();
            car.setX(getX() - 5);
            car.setY(getY());
        }
        else throw new IllegalArgumentException("Can't unload because ramp is up");
    }



}
