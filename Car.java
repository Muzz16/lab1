import java.awt.*;

public class Car {
    private final int nrDoors; // Number of doors on the car
    public final double enginePower; // Engine power of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name
    public double currentSpeed; // The current speed of the car

    public Car(int nrDoors, double enginePower, String modelName, Color color){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.color = color;
    }

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        this.color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }
}
