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
    GraphicsFactory gf;
    ArrayList<Car> cars;

    void moveit(Car car, int x, int y) {
        Point newPos = new Point(x, y);
        gf.carPositions.put(car, newPos);
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<Car> cars) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.pink);
        this.gf = new GraphicsFactory();
        this.cars = cars;

        try {
            gf.loadImages(cars);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        gf.drawCars(g, cars);
        gf.drawWorkshop(g);
    }
}
