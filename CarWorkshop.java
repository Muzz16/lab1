import java.util.ArrayList;
import java.util.List;
public class CarWorkshop<T extends Car>{

    private List<T> carsInWorkshop = new ArrayList<>();
    private int currentCapacity;
    private int maxCapacity;

    public CarWorkshop(int maxCapacity){
        this.maxCapacity = maxCapacity;
        this.currentCapacity = 0;
    }

    public void add(T car){
        if(currentCapacity < maxCapacity){
            carsInWorkshop.add(car);
        }
        else throw new IllegalArgumentException("Workshop is full");
    }

    public T removeCar(T car){
        carsInWorkshop.remove(car);
        return car;
    }

}
