package spirals.ulam.examples;

import lombok.extern.log4j.Log4j2;
import math.PrimeUtils;
import matrix.operations.MatrixContentOperations;
import spirals.ulam.generators.SimpleUlamGenerator;
import translation.MatrixToMatrixTranslation;
import translation.PixelDataTranslator;
import translation.functions.Long2LongFunction;
import translation.functions.Long2PixelData;
import utils.export.OutputPathProvider;
import visualtization.DefaultImageExporter;
import visualtization.PixelData;

import java.io.File;
import java.io.IOException;

/**
 * Creates density representation of Ulam spiral and saves it as image. Density calculation strategy can be customized.
 */
@Log4j2
public class E06_DensityWithRadiusAndBias {

    //todo really poor performance

    private static final int SIZE = 1001;
    private static final int RADIUS = 3;
    private static final int PRIME_BIAS = 3;

    private static final int PRIME_CHANNEL = 1;       //  0 - red, 1 - green, 2 - blue
    private static final int RED_BASE_VALUE = 10;
    private static final int GREEN_BASE_VALUE = 0;
    private static final int BLUE_BASE_VALUE = 50;

    public static void main(String[] args) throws IOException {
        long [][] matrix = SimpleUlamGenerator.generateMatrix(SIZE);
        long[][] densityMatrix = calculateDensityMatrix(matrix);
        PixelData[][] imageData = mapDensityToPixelData(densityMatrix);
        String path = OutputPathProvider.getOutputPath(prepareFilename(), SIZE, ".png", E06_DensityWithRadiusAndBias.class);
        DefaultImageExporter.generateImage(imageData, new File(path));
    }

    private static PixelData[][] mapDensityToPixelData(long[][] densityMatrix) {
        long maxDensityValue = MatrixContentOperations.getMaxValue(densityMatrix);
        int step = 255 / (int) maxDensityValue;
        Long2PixelData func = (matrix, i, j) -> calculatePixelValue(step, matrix, i, j);
        return PixelDataTranslator.translate(densityMatrix, func);
    }

    @SuppressWarnings("ConstantConditions")
    private static PixelData calculatePixelValue(int step, long[][] matrix, int i, int j) {
        int pixelValue = (int) matrix[i][j] * step;

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

        return new PixelData(red, green, blue);
    }

    private static long[][] calculateDensityMatrix(long[][] matrix) {
        Long2LongFunction func = (m, i, j) -> {
            long densityValue = MatrixContentOperations.getElementsWithinRadius(m, i, j, RADIUS).stream()
                    .filter(PrimeUtils::isPrime)
                    .count();
            if (PrimeUtils.isPrime(matrix[i][j])) {
                densityValue += PRIME_BIAS;
            }
            return densityValue;
        };
        return MatrixToMatrixTranslation.translate(matrix, func);
    }

    private static String prepareFilename() {
        String color = PRIME_CHANNEL == 0 ? "red" : PRIME_CHANNEL == 1 ? "green" : "blue";
        return String.format("density_radius_%s_bias_%s_%s", RADIUS, PRIME_BIAS, color);
    }

}
