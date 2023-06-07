package spirals.ulam.export.image;

import lombok.experimental.UtilityClass;

import java.awt.image.BufferedImage;

import static spirals.ulam.utils.Validator.*;

@UtilityClass
public class DensityImageExporter extends AbstractImageExporter {

    public int RED_BASE_VALUE = 0;
    public int GREEN_BASE_VALUE = 0;
    public int BLUE_BASE_VALUE = 0;

    public int PRIME_CHANNEL = 0; // 0 = RED, 1 = GREEN, 2 = BLUE

    public void generateImage(short[][] matrix, String outputPath) {
        validateMatrix(matrix);
        writeToFile(outputPath, createBufferedImage(matrix));
    }

    private BufferedImage createBufferedImage(short[][] matrix) {
        int size = matrix.length;
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);

        int maxDensityValue = findMaxDensityValue(matrix);
        int step = 255 / maxDensityValue;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int val = calculatePixelValue(matrix[i][j] * step);
                image.setRGB(j, i, val);
            }
        }
        return image;
    }

    private static int calculatePixelValue(int pixelValue) {
        int red = RED_BASE_VALUE;
        int green = GREEN_BASE_VALUE;
        int blue = BLUE_BASE_VALUE;
        if (PRIME_CHANNEL == 0) {
            red += pixelValue;
        } else if (PRIME_CHANNEL == 1) {
            green += pixelValue;
        } else if (PRIME_CHANNEL == 2) {
            blue += pixelValue;
        } else {
            throw new IllegalArgumentException("CHANNEL must be 0, 1, or 2");
        }
        red = Math.min(red, 255);
        green = Math.min(green, 255);
        blue = Math.min(blue, 255);
        return (red << 16) + (green << 8) + blue;
    }

    private static int findMaxDensityValue(short[][] matrix) {
        int maxDensityValue = 0;
        for (short[] row : matrix) {
            for (short value : row) {
                if (value > maxDensityValue) {
                    maxDensityValue = value;
                }
            }
        }
        return maxDensityValue;
    }
}
