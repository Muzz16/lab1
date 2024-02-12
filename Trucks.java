import java.awt.*;
public abstract class Trucks extends Car{

    public Trucks(int doors, int power, String model, Color color){
        super(doors, power, model, color);
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
    public double speedFactor() {
        return enginePower * 0.01;
    }

}
