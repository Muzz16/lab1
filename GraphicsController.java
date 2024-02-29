import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

class GraphicsController extends JPanel{
    HashMap<Car, BufferedImage> carImages = new HashMap<>();
    HashMap<Car, Point> carPositions = new HashMap<>();
    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300, 50);
    ArrayList<String> imagePaths = new ArrayList<>();

    public void loadImages(ArrayList<Car> cars) throws IOException {
        imagePaths.clear();
        carImages.clear();
        carPositions.clear();

        imagePaths.add("pics/Volvo240.jpg");
        imagePaths.add("pics/Saab95.jpg");
        imagePaths.add("pics/Scania.jpg");

        for (Car car : cars) {
            if(car instanceof Volvo240) {
                carImages.put(car, ImageIO.read(getClass().getResourceAsStream(imagePaths.get(0))));
            }
            if(car instanceof Saab95){
                carImages.put(car, ImageIO.read(getClass().getResourceAsStream(imagePaths.get(1))));
            }
            if(car instanceof Scania){
                carImages.put(car, ImageIO.read(getClass().getResourceAsStream(imagePaths.get(2))));
            }
        }
        volvoWorkshopImage = ImageIO.read(getClass().getResourceAsStream("pics/VolvoBrand.jpg"));

        int pixels = 50;
        for (int i = 0; i < cars.size(); i++) {
            carPositions.put(cars.get(i), new Point(0, pixels));
            pixels += 100;
            if(pixels > getHeight()){
                pixels = 0;
            }
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