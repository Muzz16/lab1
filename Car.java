import java.awt.*;

public class Car implements Movable {
    private final int nrDoors; // Number of doors on the car
    protected final double enginePower; // Engine power of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name
    protected double currentSpeed; // The current speed of the car
    private int direction; // north = 0, east = 1, south = 2, west = 3
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
            case 0: // facing north
                yPos += currentSpeed;
                break;
            case 1: // facing east
                xPos += currentSpeed;
                break;
            case 2: // facing south
                yPos -= currentSpeed;
                break;
            case 3: // facing west
                xPos -= currentSpeed;
                break;
            default:
                break;
        }
    }

    public void incrementSpeed(double amount) {
    }

    public void decrementSpeed(double amount) {
    }

    public void gas(double amount) {
        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
            currentSpeed = Math.min(getCurrentSpeed(),enginePower);
            if(currentSpeed < 0){
                currentSpeed = Math.max(getCurrentSpeed(),0);
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
            System.out.println("Invalid brake range");
        }
    }

    public void turnLeft(){
        direction = (direction + 3) % 4;
    }

    public void turnRight(){
        direction = (direction + 1) % 4;
    }
}
