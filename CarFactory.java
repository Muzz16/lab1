public class CarFactory {
    public static Car createCar(Car carType) {
        if (carType instanceof Volvo240) {
            return new Volvo240();
        } else if (carType instanceof Saab95) {
            return new Saab95();
        } else if(carType instanceof Scania){
            return new Scania();
        }
        else {
            throw new IllegalArgumentException("Invalid car type");
        }
    }
}
