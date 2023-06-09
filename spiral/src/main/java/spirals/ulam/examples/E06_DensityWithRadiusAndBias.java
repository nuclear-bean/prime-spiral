package spirals.ulam.examples;

import lombok.extern.log4j.Log4j2;
import matrix.operations.MatrixContentOperations;
import spirals.ulam.generators.SimpleUlamGenerator;
import translation.MatrixTranslator;
import translation.functions.Boolean2LongFunction;
import translation.functions.Long2BooleanFunction;
import translation.functions.Long2PixelData;
import utils.ElapsedTimer;
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

    private static final int SIZE = 2001;
    private static final int RADIUS = 3;
    private static final int PRIME_BIAS = 3;

    private static final int PRIME_CHANNEL = 1;       //  0 - red, 1 - green, 2 - blue
    private static final int RED_BASE_VALUE = 10;
    private static final int GREEN_BASE_VALUE = 0;
    private static final int BLUE_BASE_VALUE = 50;

    public static void main(String[] args) throws IOException {
        ElapsedTimer.start();
        long [][] matrix = generateBaseMatrix();
        boolean [][] booleanMatrix = translateToBooleanMatrix(matrix);
        long [][] densityMatrix = calculateDensityMatrix(booleanMatrix);
        PixelData[][] imageData = calculatePixelData(densityMatrix);
        DefaultImageExporter.generateImage(imageData, getOutputFile());
    }

    private static File getOutputFile() {
        String color = PRIME_CHANNEL == 0 ? "red" : PRIME_CHANNEL == 1 ? "green" : "blue";
        String fileName = String.format("density_radius_%s_bias_%s_%s", RADIUS, PRIME_BIAS, color);
        String path = OutputPathProvider.getOutputPath(fileName, SIZE, ".png", E06_DensityWithRadiusAndBias.class);
        return new File(path);
    }

    private static long[][] generateBaseMatrix() {
        log.info("Generating base matrix ...");
        return SimpleUlamGenerator.generateMatrix(SIZE);
    }

    private static long[][] calculateDensityMatrix(boolean[][] booleanMatrix) {
        log.info("Calculating density ...");
        Boolean2LongFunction function = (matrix, i, j) -> {
            long val = MatrixContentOperations.getCountOfTrueCellsWithinRadius(booleanMatrix, i, j, RADIUS);
            if (booleanMatrix[i][j]) {
                val += PRIME_BIAS;
            }
            return val;
        };
        return MatrixTranslator.translate(booleanMatrix, function);
    }

    private static boolean[][] translateToBooleanMatrix(long[][] matrix) {
        log.info("Translating to boolean matrix ...");
        return MatrixTranslator.translate(matrix, Long2BooleanFunction.PRIME);
    }

    private static PixelData[][] calculatePixelData(long[][] densityMatrix) {
        log.info("Calculating pixel data ...");
        long maxDensityValue = MatrixContentOperations.getMaxValue(densityMatrix);
        int step = 255 / (int) maxDensityValue;
        Long2PixelData function = Long2PixelData.BASIC_DENSITY(
                RED_BASE_VALUE,
                GREEN_BASE_VALUE,
                BLUE_BASE_VALUE,
                PRIME_CHANNEL,
                step
        );
        return MatrixTranslator.translate(densityMatrix, function);
    }

}
