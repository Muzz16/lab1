import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CarTest {
    Car testCar;
    Car testCar2;

    @Before
    public void init(){
        testCar = new Volvo240();
        testCar2 = new Saab95();
    }

    @Test
    public void getNrDoors() {
        int i = testCar.getNrDoors();
        assertEquals(4,i);
    }

    @Test
    public void getEnginePower() {
        double i = testCar.getEnginePower();
        assertEquals(100,i,0.001);
    }

    @Test
    public void getCurrentSpeed() {
        testCar.stopEngine();
        double i = testCar.getCurrentSpeed();
        assertEquals(0,i,0.001);
    }

    @Test
    public void getColor() {
        Color c = testCar.getColor();
        assertEquals(Color.black,c);
    }

    @Test
    public void setColor() {
        testCar.setColor(Color.red);
        assertEquals(Color.red, testCar.getColor());
    }

    @Test
    public void startEngine() {
        testCar.startEngine();
        assertEquals(0.1,testCar.getCurrentSpeed(),0.001);
    }

    @Test
    public void stopEngine() {
        testCar.stopEngine();
        assertEquals(0,testCar.getCurrentSpeed(),0.001);
    }

    @Test
    public void getxPos(){
        double i = testCar.getxPos();
        assertEquals(0,i,0.001);
    }

    @Test
    public void getyPos(){
        double i = testCar.getyPos();
        assertEquals(0,i,0.001);
    }


    @Test
    public void move() {
        testCar.stopEngine();
        testCar.move();
        assertEquals(0,testCar.getxPos(),0.001);
    }

    @Test
    public void turnLeft() {
        testCar.turnLeft();
        assertEquals(3,testCar.getDirection());
    }

    @Test
    public void turnRight() {
        testCar.turnRight();
        assertEquals(1,testCar.getDirection());
    }

    @Test
    public void gas() {
        testCar.gas(0);
        assertEquals(0,testCar.getCurrentSpeed(),0.001);
    }
    @Test
    public void brake() {
        testCar.brake(0);
        assertEquals(0,testCar.getCurrentSpeed(), 0.001);
    }

    @Test
    public void speedFactorVolvo() {
        double i = testCar.speedFactor();
        assertEquals(1.25,i,0.001);
    }

    @Test
    public void speedFactorSaab(){
        double i = testCar2.speedFactor();
        assertEquals(1.25,i,0.001);
    }

    @Test
    public void incrementSpeedVolvo() {
        testCar.incrementSpeed(0);
        assertEquals(0,testCar.getCurrentSpeed(),0.001);
    }

    @Test
    public void decrementSpeedVolvo() {
        testCar.decrementSpeed(0);
        assertEquals(0,testCar.getCurrentSpeed(),0.001);
    }

    @Test
    public void incrementSpeedSaab() {
        testCar.incrementSpeed(0);
        assertEquals(0,testCar2.getCurrentSpeed(),0.001);
    }

    @Test
    public void decrementSpeedSaab() {
        testCar.decrementSpeed(0);
        assertEquals(0,testCar2.getCurrentSpeed(),0.001);
    }
}