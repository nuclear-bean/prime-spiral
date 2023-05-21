package spiral.core.image;

import spiral.core.utils.PrimeUtils;
import spiral.core.utils.Validator;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Will generate a black and white image from a matrix - black pixels for prime numbers, white pixels for non-prime numbers.
 */
public class BlackAndWhiteImageGenerator implements ImageGenerator {

    @Override
    public void generateImage(long[][] matrix, String outputPath) {
        generateImageFromMatrix(matrix, outputPath);
    }

    private void generateImageFromMatrix(long[][] matrix, String outputPath) {
        validateMatrix(matrix);
        BufferedImage image = createBufferedImage(matrix);
        writeToFile(outputPath, image);
    }

    private void writeToFile(String outputPath, BufferedImage image) {
        try {
            File outputFile = new File(outputPath);
            ImageIO.write(image, "png", outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BufferedImage createBufferedImage(long[][] matrix) {
        int size = matrix.length;
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_BYTE_BINARY);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int pixelValue = (PrimeUtils.isPrime(matrix[i][j])) ? Color.BLACK.getRGB() : Color.WHITE.getRGB();
                image.setRGB(j, i, pixelValue);
            }
        }
        return image;
    }

    private void validateMatrix(long[][] matrix) {
        Validator.validateMatrix(matrix);
    }

}


