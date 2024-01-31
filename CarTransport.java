import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CarTransport extends Truck{
    private boolean rampIsClosed;
    private int rangeDiff = 5;
    private Deque<Car> carsLoaded = new ArrayDeque<>();

    public CarTransport() {
        super(2,140,"CarTransport",Color.black);
        this.rampIsClosed = true;
    }

    public void rampSwitch(){
        if(rampIsClosed == true && notMoving()){
            rampIsClosed = false;
        }
        else rampIsClosed = true;
    }

    @Override
    public boolean CarisClose(Car car){
        if((car.getX() >= (getX()-rangeDiff)) && (car.getY() == getY() )){
            return true;
        }
        return false;
    }

    @Override
    public boolean CarIsNotCarTransport(Car car){
        if(car instanceof CarTransport){
            return false;
        }
        else return true;
    }

    public void loadCars(Car car){
        if(!rampIsClosed && CarisClose(car) && CarIsNotCarTransport(car)){
            carsLoaded.push(car);
            car.setX(getX());
            car.setY(getY());
        }
        else throw new IllegalArgumentException("Can't load car because car is too far away or ramp is up");
    }

    public void unloadCars(Car car){
        if(rampIsClosed == false){
            carsLoaded.pop();
            car.setX(getX() - rangeDiff);
            car.setY(getY());
        }
        else throw new IllegalArgumentException("Can't unload because ramp is up");
    }

    @Override
    public boolean canMove(){
        return rampIsClosed;
    }

    @Override
    public boolean contains(Car car){
        return carsLoaded.contains(car);
    }
}
