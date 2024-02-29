public class RampClosedState implements hasTruckRamp{

    hasTruckRamp rampState;
    @Override
    public boolean isRampClosed() {
        return false;
    }

    @Override
    public void lowerRamp() {
        throw new IllegalArgumentException("Already lowered");
    }

    @Override
    public void raiseRamp() {
        setRampState(new RampOpenState());
    }

    public void setRampState(hasTruckRamp state){
        rampState = state;
    }
}
