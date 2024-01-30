import java.util.ArrayList;
import java.util.List;
public class CarWorkshop<T extends Car>{

    private List<T> carsInWorkshop;
    private int currentCapacity;
    private int maxCapacity;

    public CarWorkshop(int maxCapacity){
        this.maxCapacity = maxCapacity;
        this.currentCapacity = 0;
        this.carsInWorkshop = new ArrayList<>();
    }

    public void add(T car){
        if(currentCapacity < maxCapacity){
            carsInWorkshop.add(car);
            currentCapacity = carsInWorkshop.size();
        }
        else throw new IllegalArgumentException("Workshop is full");
    }

    public T removeCar(T car){
        if(currentCapacity > 0) {
            carsInWorkshop.remove(car);
            currentCapacity = carsInWorkshop.size();
            return car;
        }
        else throw new IllegalArgumentException("Empty or the car doesn't exist");
    }

    public boolean contains(T car){
        if(carsInWorkshop.contains(car)){
            return true;
        }
        else return false;
    }

}
