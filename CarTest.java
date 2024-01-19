import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CarTest {
    Car testCar;
    @Before
    public void init(){
        testCar = new Car(4,100,"Volvo240",Color.black);
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
}