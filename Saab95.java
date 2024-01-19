import java.awt.*;

public class Saab95 extends Car{

    public boolean turboOn;
    
    public Saab95(){
        super(2,125,"Saab95",Color.red);
        stopEngine();
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }
    
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

     public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
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
