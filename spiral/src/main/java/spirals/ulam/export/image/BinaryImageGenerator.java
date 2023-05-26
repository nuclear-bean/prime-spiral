package spirals.ulam.export.image;

import lombok.experimental.UtilityClass;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Will generate a black and white spirals.ulam.export.image from a matrix - black pixels for prime numbers, white pixels for non-prime numbers.
 */
@UtilityClass
public class BinaryImageGenerator extends AbstractImageExporter {

    public void generateImage(short[][] matrix, String outputPath) {
        //todo generic validate matrix size
        writeToFile(outputPath, createBufferedImage(matrix));
    }

    private BufferedImage createBufferedImage(short[][] matrix) {
        int size = matrix.length;
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_BYTE_BINARY);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int pixelValue = matrix[i][j] == 1 ? Color.BLACK.getRGB() : Color.WHITE.getRGB();
                image.setRGB(j, i, pixelValue);
            }
        }
        return image;
    }
}
