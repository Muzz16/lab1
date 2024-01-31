import java.util.ArrayDeque;
import java.util.List;
import java.util.Deque;

public class CarStack <T extends Car>{

    private Deque<T> carsInWorkshop;
    private int currentCapacity;
    private int maxCapacity;

    public CarStack(int maxCapacity){
        this.maxCapacity = maxCapacity;
        this.currentCapacity = 0;
        this.carsInWorkshop = new ArrayDeque<>();
    }

    public void add(T car){
        if(currentCapacity < maxCapacity){
            carsInWorkshop.push(car);
            currentCapacity = carsInWorkshop.size();
        }
        else throw new IllegalArgumentException("full");
    }

    public T removeCar(){
        if(currentCapacity > 0) {
            T car = carsInWorkshop.pop();
            currentCapacity = carsInWorkshop.size();
            return car;
        }
        else throw new IllegalArgumentException("Empty");
    }


    public boolean contains(T car) {
        return carsInWorkshop.contains(car);
    }
}
