import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Saab95Test {

    Saab95 saab95;
    @Before
    public void init(){
        saab95 = new Saab95();
    }
    @Test
    public void setTurboOn() {
        saab95.setTurboOn();
        assertTrue(saab95.turboOn);
    }

    @Test
    public void setTurboOff() {
        saab95.setTurboOff();
        assertFalse(saab95.turboOn);
    }

    @Test
    public void speedFactor() {
        saab95.setTurboOn();
        double i = saab95.speedFactor();
        assertEquals(1.625,i,0.001);
    }

    @Test
    public void incrementSpeed() {
        saab95.incrementSpeed(0);
        assertEquals(0,saab95.getCurrentSpeed(),0.001);
    }

    @Test
    public void decrementSpeed() {
        saab95.decrementSpeed(0);
        assertEquals(0,saab95.getCurrentSpeed(),0.001);
    }

    @Test
    public void gas() {
        saab95.setTurboOn();
        saab95.gas(1);
        assertEquals(1.625,saab95.getCurrentSpeed(),0.001);

    }

    @Test
    public void brake() {
        saab95.brake(1);
        assertEquals(0,saab95.getCurrentSpeed(),0.001);
    }
}