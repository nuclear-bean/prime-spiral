package spiral.experimental;

import lombok.experimental.UtilityClass;
import spiral.core.utils.annotations.ExternalCode;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

@UtilityClass

public class ImageGenerator {

    @ExternalCode
    public static void main(String[] args) throws IOException {
        short[][] input = {{255, 0, 255}, {0, 255, 0}, {255, 255, 0}}; // example input data
        int width = input[0].length;
        int height = input.length;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int pixelValue = input[row][col];
                g2d.setColor(new Color(pixelValue, pixelValue, pixelValue)); // set the color of the pixel based on the input value
                g2d.fillRect(col, row, 1, 1); // draw a single pixel at the current position
            }
        }
        g2d.dispose();
        File output = new File("output.png");
        ImageIO.write(image, "png", output); // write the image to a PNG file
    }

    public void render(long [][] matrix) {

    }

}
