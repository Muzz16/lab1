import java.awt.*;
import java.io.IOException;
import javax.swing.*;
import java.util.ArrayList;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel {
    GraphicsController gc;
    ArrayList<Car> cars;

    void moveit(Car car, int x, int y) {
        Point newPos = new Point(x, y);
        gc.carPositions.put(car, newPos);
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<Car> cars) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.pink);
        this.gc = new GraphicsController();
        this.cars = cars;

        try {
            gc.loadImages(cars);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        gc.drawCars(g, cars);
        gc.drawWorkshop(g);
    }
}
