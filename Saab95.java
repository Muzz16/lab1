import java.awt.*;

public class Saab95 extends Car{

    protected boolean turboOn;
    
    public Saab95(){
        super(2,125,"Saab95",Color.red);
        stopEngine();
    }

    @Override
    public void setTurboOn(){
	    turboOn = true;
    }

    @Override
    public void setTurboOff(){
	    turboOn = false;
    }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    @Override
    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    @Override
     public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }
}
