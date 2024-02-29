public class RampOpenState implements hasTruckRamp{
    hasTruckRamp rampState;
    @Override
    public boolean isRampClosed() {
        return false;
    }

    @Override
    public void lowerRamp() {
        setRampState(new RampClosedState());
    }

    @Override
    public void raiseRamp() {
        throw new IllegalArgumentException("Already opened");
    }

    @Override
    public void setRampState(hasTruckRamp state){
        rampState = state;
    }
}
