import java.awt.*;

public class CarTransport extends Trucks implements hasTruckRamp,hasCarStack<Car>{
    protected boolean rampIsClosed;
    private int rangeDiff = 5;
    private CarStack<Car> carStack;
    private hasTruckRamp state;

    public CarTransport() {
        super(2,140,"CarTransport",Color.black);
        this.rampIsClosed = true;
        carStack = new CarStack<>(4);
        this.state = new RampClosedState();
    }

    public boolean isRampClosed(){
        return state.isRampClosed();
    }

    /*
    public boolean rampSwitch(){
        if(rampIsClosed == true && notMoving()){
            return rampIsClosed = false;
        }
        else return rampIsClosed = true;
    }

     */

    @Override
    public boolean CarisClose(Car car){
        if((car.getX() >= (getX()-rangeDiff)) && (car.getY() == getY() )){
            return true;
        }
        return false;
    }

    @Override
    public boolean CarIsNotCarTransport(Car car){
        if(car instanceof CarTransport){
            return false;
        }
        else return true;
    }


    @Override
    public boolean canMove(){
        return rampIsClosed;
    }

    @Override
    public boolean contains(Car car){
        return carStack.contains(car);
    }


    @Override
    public void add(Car car) {
        carStack.add(car);
    }

    @Override
    public Car removeCar() {
        return carStack.removeCar();
    }

    @Override
    public void lowerRamp() {
        state.lowerRamp();
    }

    @Override
    public void raiseRamp() {
        state.raiseRamp();
    }

    @Override
    public void setRampState(hasTruckRamp state) {
        this.state = state;
    }
}
