import java.awt.*;

public class Car {
    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private final double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name

    public Car(int nrDoors, double enginePower, double currentSpeed, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.modelName = modelName;
    }
}
