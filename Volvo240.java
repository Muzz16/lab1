import java.awt.*;

public class Volvo240 extends Car {
    public final static double trimFactor = 1.25;

    public Volvo240() {
        super(4, 100, "Volvo240", Color.black);
        stopEngine();
    }

    public double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }

    public void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    public void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    // TODO fix this method according to lab pm
    public void gas(double amount) {
        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
            double speed = getCurrentSpeed();
            currentSpeed = Math.min(speed,enginePower);
            if(currentSpeed < 0){
                currentSpeed = Math.max(speed,0);
            }
        }
        else{
            System.out.println("Invalid gas range");
        }
    }

    // TODO fix this method according to lab pm
    public void brake(double amount) {
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
            double speed = getCurrentSpeed();
            currentSpeed = Math.min(speed,enginePower);
            if(currentSpeed < 0){
                currentSpeed = Math.max(speed,0);
            }
        }
        else{
            System.out.println("Invalid gas range");
        }
    }
}
