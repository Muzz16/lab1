public interface hasTruckRamp {
    boolean isRampClosed();

    void lowerRamp();

    void raiseRamp();

    void setRampState(hasTruckRamp state);
}
