import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
public class CarWorkshop<T extends Car> implements hasCarStack<T>{

    private CarStack<T> carsInWorkshop;
    public CarWorkshop(){
        this.carsInWorkshop = new CarStack<>(4);

    }

    @Override
    public boolean contains(T car){
        return carsInWorkshop.contains(car);
    }


    @Override
    public void add(T car) {
        carsInWorkshop.add(car);
    }

    @Override
    public T removeCar() {
        return carsInWorkshop.removeCar();
    }

}
