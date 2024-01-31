import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CarWorkshopTest{

    CarWorkshop<Volvo240> volvoWorkshop;
    Volvo240 volvo;
    Saab95 saab;
    @Before
    public void init(){
        volvo = new Volvo240();
        saab = new Saab95();
        volvoWorkshop = new CarWorkshop();
    }

}