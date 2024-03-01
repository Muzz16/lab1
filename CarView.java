import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class CarView extends JFrame implements CarObserver{

    // The controller member
    CarController carC;

    // Constructor
    public CarView(String framename, CarController cc){
        this.carC = cc;
        carC.drawPanel = new DrawPanel(CarController.X, CarController.Y-240, carC.cars);
        carC.initComponents(framename);
    }

    @Override
    public void carUpdated() {
        repaint();
    }

}