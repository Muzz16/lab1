import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    ArrayList<Car> cars;
    GraphicsFactory gf;

    // TODO: Make this general for all cars
    void moveit(Car car, int x, int y) {
        Point newPos = new Point(x, y);
        gf.carPositions.put(car, newPos);
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<Car> cars) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.pink);
        this.cars = cars;
        this.gf = new GraphicsFactory();

        try {
            gf.loadImages(cars);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        gf.drawCars(g, cars);
        gf.drawWorkshop(g);
    }
}
