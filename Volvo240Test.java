import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Volvo240Test {

    Volvo240 volvo;
    @Before
    public void init(){
        volvo = new Volvo240();
    }
    @Test
    public void speedFactor() {
        double i = volvo.speedFactor();
        assertEquals(1.25,i,0.001);
    }

    @Test
    public void incrementSpeed() {
        volvo.incrementSpeed(0);
        assertEquals(0,volvo.getCurrentSpeed(),0.001);
    }

    @Test
    public void decrementSpeed() {
        volvo.decrementSpeed(0);
        assertEquals(0,volvo.getCurrentSpeed(),0.001);
    }

    @Test
    public void gas() {
        volvo.gas(1);
        assertEquals(1.25,volvo.getCurrentSpeed(),0.001);
    }

    @Test
    public void brake() {
        volvo.brake(1);
        assertEquals(0,volvo.getCurrentSpeed(),0.001);
    }
}