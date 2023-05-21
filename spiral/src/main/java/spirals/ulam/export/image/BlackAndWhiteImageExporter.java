package spirals.ulam.export.image;

import lombok.experimental.UtilityClass;
import math.PrimeUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

import static spirals.ulam.utils.Validator.validateMatrix;

/**
 * Will generate a black and white spirals.ulam.export.image from a matrix - black pixels for prime numbers, white pixels for non-prime numbers.
 */
@UtilityClass
public class BlackAndWhiteImageExporter extends AbstractImageExporter {

    public void generateImage(long[][] matrix, String outputPath) {
        validateMatrix(matrix);
        writeToFile(outputPath, createBufferedImage(matrix));
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
}
