import java.awt.*;

public class Scania extends Trucks implements hasTruckBed{

    private double rampAngle;
    public Scania(){
        super(2,110,"Scania", Color.white);
        rampAngle = 0;
        stopEngine();
    }

    @Override
    public void increaseAngle(double amount){
        if(notMoving()) {
            rampAngle = Math.min(rampAngle + amount, 70);
        }
        else throw new IllegalArgumentException("Truck is moving");
    }

    @Override
    public void decreaseAngle(double amount){
        if(notMoving()) {
            rampAngle = Math.max(rampAngle - amount, 0);
        }
        else throw new IllegalArgumentException("Truck is moving");
    }

    @Override
    public double getRampAngle(){
        return rampAngle;
    }

    @Override
    public boolean canMove(){
        if(rampAngle == 0){
            return true;
        }
        return false;
    }

    @Override
    public void startEngine(){
        if(rampAngle > 0){
            currentSpeed = 0;
            engineStatus = false;
            throw new IllegalArgumentException("Can't move while ramp is down");
        }
        else{
            currentSpeed = 0.1;
            engineStatus = true;
        }
    }
}
