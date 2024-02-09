import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    HashMap<Car, BufferedImage> carImages = new HashMap<>();
    HashMap<Car, Point> carPositions = new HashMap<>();

    ArrayList<Car> cars;


    // To keep track of a single car's position
    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300,300);

    // TODO: Make this general for all cars
    void moveit(Car car,int x, int y){
            Point newPos = new Point(x,y);
            carPositions.put(car,newPos);

    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<Car> cars) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.pink);
        this.cars = cars;
        carPositions.put(cars.get(0), new Point(50,400));
        carPositions.put(cars.get(1), new Point(50,150));
        carPositions.put(cars.get(2), new Point(50,250));
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            carImages.put(cars.get(0),ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
            carImages.put(cars.get(1),ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
            carImages.put(cars.get(2),ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(carImages.get(cars.get(0)), (int) carPositions.get(cars.get(0)).x, (int) carPositions.get(cars.get(0)).y, null); // see javadoc for more info on the parameters
        g.drawImage(volvoWorkshopImage, (int) volvoWorkshopPoint.x, (int) volvoWorkshopPoint.y, null);
        g.drawImage(carImages.get(cars.get(1)), (int) carPositions.get(cars.get(1)).x, (int) carPositions.get(cars.get(1)).y, null);
        g.drawImage(carImages.get(cars.get(2)), (int) carPositions.get(cars.get(2)).x, (int) carPositions.get(cars.get(2)).y,null);
    }
}
