public interface hasCarStack<T extends Car> {
    void add(T car);
    T removeCar();

    boolean contains(T car);
}
