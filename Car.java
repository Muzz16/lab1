import java.awt.*;

public class Car implements Movable {
    private final int nrDoors; // Number of doors on the car
    protected final double enginePower; // Engine power of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name
    protected double currentSpeed; // The current speed of the car
    private int direction; // east = 0, south = 1, west = 2, north = 3
    private double xPos; // start in xPos = 0
    private double yPos; // start in yPos = 0


    public Car(int nrDoors, double enginePower, String modelName, Color color){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.color = color;
        this.direction = 0;
        this.xPos = 0;
        this.yPos = 0;
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
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

    public int getDirection(){
        return direction;
    }

    public double getxPos(){
        return xPos;
    }

    public double getyPos(){
        return yPos;
    }
    public void move(){
        switch (direction){
            case 0: // facing east
                currentSpeed += xPos;
                break;
            case 1: // facing south
                currentSpeed -= yPos;
                break;
            case 2: // facing west
                currentSpeed -= xPos;
                break;
            case 3: // facing north
                currentSpeed += yPos;
                break;
            default:
                break;
        }
    }

    public void turnLeft(){
        direction = (direction + 3) % 4;
    }

    public void turnRight(){
        direction = (direction + 1) % 4;
    }
}
