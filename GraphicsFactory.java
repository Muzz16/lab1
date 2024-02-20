import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

class GraphicsFactory {
    HashMap<Car, BufferedImage> carImages = new HashMap<>();
    HashMap<Car, Point> carPositions = new HashMap<>();
    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300, 50);

    public void loadImages(ArrayList<Car> cars) throws IOException {
        ArrayList<String> imagePaths = new ArrayList<>();
        imagePaths.add("pics/Volvo240.jpg");
        imagePaths.add("pics/Saab95.jpg");
        imagePaths.add("pics/Scania.jpg");

        for (int i = 0; i < imagePaths.size(); i++) {
            carImages.put(cars.get(i), ImageIO.read(getClass().getResourceAsStream(imagePaths.get(i))));
        }
        volvoWorkshopImage = ImageIO.read(getClass().getResourceAsStream("pics/VolvoBrand.jpg"));

        int pixels = 50;
        for (int i = 0; i < cars.size(); i++) {
            carPositions.put(cars.get(i), new Point(0, pixels));
            pixels += 100;
        }
    }

    public void drawCars(Graphics g, ArrayList<Car> cars) {
        for (Car car : cars) {
            g.drawImage(carImages.get(car), (int) carPositions.get(car).x, (int) carPositions.get(car).y, null);
        }
    }

    public void drawWorkshop(Graphics g) {
        g.drawImage(volvoWorkshopImage, (int) volvoWorkshopPoint.x, (int) volvoWorkshopPoint.y, null);
    }

}