import java.awt.*;

public class Scania extends CarTransport{

    private double rampAngle;
    private final static double trimFactor = 1.75;
    public Scania(){
        super(2,120,"Scania", Color.white);
        rampAngle = 0;
        stopEngine();
    }

    @Override
    public double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }

    @Override
    public void increaseAngle(double amount){
        if(currentSpeed == 0) {
            rampAngle = Math.min(rampAngle + amount, 70);
        }
        else throw new IllegalArgumentException("Truck is moving");
    }

    @Override
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
    public boolean canMove(){
        if(rampAngle == 0){
            return true;
        }
        return false;
    }
}
