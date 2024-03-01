public class CarFactory {
    public static Volvo240 createVolvo240(){
        Volvo240 volvo = new Volvo240();
        volvo.setY(50);
        volvo.setX(0);
        return volvo;
    }

    public static Saab95 createSaab95(){
        Saab95 saab95 = new Saab95();
        saab95.setY(150);
        saab95.setX(0);
        return saab95;
    }

    public static Scania createScania(){
        Scania scania = new Scania();
        scania.setY(250);
        scania.setX(0);
        return scania;
    }
}
