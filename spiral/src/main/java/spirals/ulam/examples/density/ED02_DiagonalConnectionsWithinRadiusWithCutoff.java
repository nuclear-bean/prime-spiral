package spirals.ulam.examples.density;

import export.image.RGBChannel;
import lombok.extern.log4j.Log4j2;
import matrix.operations.MatrixContentOperations;
import spirals.ulam.generators.SimpleUlamGenerator;
import translation.MatrixTranslator;
import translation.functions.Boolean2LongFunction;
import translation.functions.Long2BooleanFunction;
import translation.functions.Long2PixelData;
import utils.ElapsedTimer;
import utils.export.OutputPathProvider;
import export.image.ImageExporter;
import export.image.PixelData;

import java.io.File;
import java.io.IOException;

import static export.image.RGBChannel.*;

@Log4j2
public class ED02_DiagonalConnectionsWithinRadiusWithCutoff {

    private static final int SIZE = 10_001;
    private static final int RADIUS = 10;
    private static final int PRIME_BIAS = 10;
    private static final int CUTOFF = 19;  // don't highlight points with value below this number

    private static final RGBChannel PRIME_CHANNEL = GREEN;
    private static final int RED_BASE_VALUE = 10;
    private static final int GREEN_BASE_VALUE = 0;
    private static final int BLUE_BASE_VALUE = 50;

    public static void main(String[] args) throws IOException {
        ElapsedTimer.start();
        long[][] matrix = generateBaseMatrix();
        boolean [][] booleanMatrix = translateToBooleanMatrix(matrix);
        long [][] densityMatrix = calculateDensityMatrix(booleanMatrix);
        PixelData[][] pixelData = calculatePixelData(densityMatrix);
        ImageExporter.generateImage(pixelData, getOutputFile());
    }

    private static long[][] generateBaseMatrix() {
        log.info("Generating base matrix ...");
        return SimpleUlamGenerator.generateMatrix(SIZE);
    }

    private static PixelData[][] calculatePixelData(long[][] densityMatrix) {
        log.info("Calculating pixel data ...");
        long maxDensityValue = MatrixContentOperations.getMaxValue(densityMatrix);
        int step = 255 / (int) maxDensityValue;
        return MatrixTranslator.translate(densityMatrix, Long2PixelData.BASIC_DENSITY(
                RED_BASE_VALUE,
                GREEN_BASE_VALUE,
                BLUE_BASE_VALUE,
                PRIME_CHANNEL,
                step
        ));
    }

    private static long[][] calculateDensityMatrix(boolean[][] booleanMatrix) {
        log.info("Calculating density matrix ...");
        Boolean2LongFunction function = (matrix, i, j) -> {
            short value = (short) MatrixContentOperations.getDiagonalCountOfTrueCellsWithinRadius(matrix, i, j, RADIUS);
            if (matrix[i][j]) {
                value += PRIME_BIAS;
            }

            return value < CUTOFF ? 0 : value;
        };
        return MatrixTranslator.translate(booleanMatrix, function);
    }

    private static boolean[][] translateToBooleanMatrix(long[][] matrix) {
        log.info("Translating to boolean matrix ...");
        return MatrixTranslator.translate(matrix, Long2BooleanFunction.PRIME);
    }

    private static File getOutputFile() {
        String fileName = String.format("highlighted_diagonals_%s_bias_%s_cutoff_%s_%s", RADIUS, PRIME_BIAS, CUTOFF, PRIME_CHANNEL.name().toLowerCase());
        String path = OutputPathProvider.prepareOutputPath(fileName, SIZE, ".png", ED02_DiagonalConnectionsWithinRadiusWithCutoff.class);
        return new File(path);
    }

}
