import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CarWorkshopTest{

    CarWorkshop<Volvo240> volvoWorkshop;
    Volvo240 volvo;
    @Before
    public void init(){
        volvo = new Volvo240();
        volvoWorkshop = new CarWorkshop(4);
    }
    @Test
    public void add() {
        volvoWorkshop.add(volvo);
        assertTrue(volvo instanceof Volvo240);
    }


}