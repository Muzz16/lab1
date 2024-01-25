import java.awt.*;

public class Scania extends Car{

    private double rampAngle;
    private final static double trimFactor = 1.75;
    public Scania(){
        super(2,120,"Scania", Color.white);
        rampAngle = 0;
        stopEngine();
    }

    public void increaseAngle(double amount){
        if(currentSpeed == 0) {
            rampAngle = Math.min(rampAngle + amount, 70);
        }
        else throw new IllegalArgumentException("Truck is moving");
    }

    public void decreaseAngle(double amount){
        if(currentSpeed == 0) {
            rampAngle = Math.max(rampAngle - amount, 0);
        }
        else throw new IllegalArgumentException("Truck is moving");
    }

    @Override
    public double getRampAngle(){
        return rampAngle;
    }

    @Override
    public double speedFactor() {
        return enginePower * 0.01 * trimFactor;
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

    @Override
    public boolean canMove(){
        if(rampAngle == 0){
            return true;
        }
        return false;
    }

}