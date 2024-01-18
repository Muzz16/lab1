import java.awt.*;

public class Volvo240 extends Car {
    public final static double trimFactor = 1.25;

    public Volvo240() {
        super(4, 100, "Volvo240", Color.black);
        stopEngine();
    }

    private double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }

    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    // TODO fix this method according to lab pm
    private void gas(double amount) {
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
    private void brake(double amount) {
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
}
