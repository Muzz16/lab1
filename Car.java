import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Car implements Movable{

    private List<CarObserver> observers = new ArrayList<>();
    private final int nrDoors; // Number of doors on the car
    protected final double enginePower; // Engine power of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name
    protected double currentSpeed; // The current speed of the car
    private Directions direction; // north = 0, east = 1, south = 2, west = 3
    protected Point position;
    protected boolean engineStatus;


    public Car(int nrDoors, double enginePower, String modelName, Color color){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.color = color;
        this.direction = Directions.EAST;
        this.position = new Point(0,0);
        // Initialize position at (0, 0)
        this.engineStatus = false;
    }

    public void addObserver(CarObserver observer){
        observers.add(observer);
    }

    private void notifyObserver(){
        for(CarObserver observer : observers){
            observer.carUpdated(this);
        }
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
        engineStatus = true;
    }

    public void stopEngine(){
        currentSpeed = 0;
        engineStatus = false;
    }

    public Directions getDirection(){
        return direction;
    }

    public void setDirection(Directions direction){
        this.direction = direction;
    }

    public void setTurboOn(){}
    public void setTurboOff(){}

    public void move(){
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
        notifyObserver();
    }

    public double speedFactor(){
        return 0;
    }

    public void incrementSpeed(double amount) {
    }

    public void decrementSpeed(double amount) {
    }

    public void increaseAngle(double amount){
    }

    public void decreaseAngle(double amount){
    }

    public void gas(double amount) {
        if(engineStatus) {
            if (amount >= 0 && amount <= 1) {
                incrementSpeed(amount);
                currentSpeed = Math.min(getCurrentSpeed(), enginePower);
                if (currentSpeed < 0) {
                    currentSpeed = Math.max(getCurrentSpeed(), 0);
                }
            } else {
                throw new IllegalArgumentException("Out of range");
            }
        }
        else{
            throw new IllegalArgumentException("Engine must be on");
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

    public boolean notMoving(){
        if(currentSpeed == 0){
            return true;
        }
        return false;
    }


    public void turnLeft(){
        direction = Directions.fromValue((direction.getValue() + 3) % 4);
        notifyObserver();
    }

    public void turnRight(){
        direction = Directions.fromValue((direction.getValue() + 1) % 4);
        notifyObserver();
    }

    public double getX() {
        return position.getX();
    }

    public void setX(double x) {
        position.x = x;
    }

    public double getY() {
        return position.getY();
    }

    public void setY(double y) {
        position.y = y;
    }

    public double getRampAngle(){
        return 0;
    }

    public boolean canMove(){
        return false;
    }

    public boolean rampSwitch(){
        return false;
    }

    public boolean CarisClose(Car car){
        return false;
    }

    public boolean CarIsNotCarTransport(Car car){
        return false;
    }

    public void add(Car car){
    }

    public Car removeCar(){
        return null;
    }

    public boolean contains(Car car){
        return false;
    }
}