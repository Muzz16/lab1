import java.awt.*;

public abstract class Car extends Directions implements Movable {
    private final int nrDoors; // Number of doors on the car
    protected final double enginePower; // Engine power of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name
    protected double currentSpeed; // The current speed of the car
    private int direction; // north = 0, east = 1, south = 2, west = 3

    private Point position;




    public Car(int nrDoors, double enginePower, String modelName, Color color){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.color = color;
        this.direction = 0;
        this.position = new Point(0,0);
        // Initialize position at (0, 0)
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


    public void move(){
        Direction direction = null;

        switch (direction){
            case NORTH: // facing north
                position.setY(position.getY()+currentSpeed);
                break;
            case EAST: // facing east
                position.setX(position.getX()+currentSpeed);
                break;
            case SOUTH: // facing south
                position.setY(position.getY()-currentSpeed);
                break;
            case WEST: // facing west
                position.setX(position.getX()-currentSpeed);
                break;
            default:
                break;
        }
    }


    public double speedFactor(){
        return 0;
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
            throw new IllegalArgumentException("Out of range");
        }
    }

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
            throw new IllegalArgumentException("Out of range");
        }
    }

    public void turnLeft(){
        direction = (direction + 3) % 4;
    }

    public void turnRight(){
        direction = (direction + 1) % 4;
    }
}