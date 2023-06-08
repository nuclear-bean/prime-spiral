package spirals.ulam.examples;

import lombok.extern.log4j.Log4j2;
import matrix.operations.MatrixContentOperations;
import spirals.ulam.export.image.DensityImageExporter;
import spirals.ulam.generators.SimpleUlamGenerator;
import translation.Boolean2LongTranslator;
import translation.Long2BooleanTranslator;
import translation.PixelDataTranslator;
import translation.functions.BooleanToLongFunction;
import translation.functions.Long2BooleanFunction;
import translation.functions.TranslationFunction;
import utils.export.OutputPathProvider;
import visualtization.DefaultImageExporter;
import visualtization.PixelData;

import java.io.File;
import java.io.IOException;

@Log4j2
public class E07_DiagonalConnectionsWithinRadius {

    private static final int SIZE = 1001;
    private static final int RADIUS = 10;
    private static final int PRIME_BIAS = 10;
    private static final int CUTOFF = 21;  // don't highlight points with value below this number

    private static final int PRIME_CHANNEL = 1;
    private static final int RED_BASE_VALUE = 10;
    private static final int GREEN_BASE_VALUE = 0;
    private static final int BLUE_BASE_VALUE = 50;

    public static void main(String[] args) throws IOException {
        long[][] matrix = SimpleUlamGenerator.generateMatrix(SIZE);
        boolean [][] booleanMatrix = translateToBooleanMatrix(matrix);
        long [][] densityMatrix = translateToDensityMatrix(booleanMatrix);
        PixelData[][] pixelData = translateDensityToPixelData(densityMatrix);
        String path = OutputPathProvider.getOutputPath(prepareFilename(), SIZE, ".png", E07_DiagonalConnectionsWithinRadius.class);
        DefaultImageExporter.generateImage(pixelData, new File(path));
    }

    private static PixelData[][] translateDensityToPixelData(long[][] densityMatrix) {
        long maxDensityValue = MatrixContentOperations.getMaxValue(densityMatrix);
        int step = 255 / (int) maxDensityValue;
        TranslationFunction func = (matrix, i, j) -> calculatePixelValue(step, matrix, i, j);
        return PixelDataTranslator.translate(densityMatrix, func);
    }

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

    private static long[][] translateToDensityMatrix(boolean[][] booleanMatrix) {
        BooleanToLongFunction function = (matrix, i, j) -> {
            short value = (short) MatrixContentOperations.getDiagonalCountOfTrueCellsWithinRadius(matrix, i, j, RADIUS);
            if (matrix[i][j]) {
                value += PRIME_BIAS;
            }

            return value < CUTOFF ? 0 : value;
        };
        return Boolean2LongTranslator.translate(booleanMatrix, function);
    }

    private static boolean[][] translateToBooleanMatrix(long[][] matrix) {
        return Long2BooleanTranslator.translate(matrix, Long2BooleanFunction.PRIME);
    }

    private static String prepareFilename() {
        String color = DensityImageExporter.PRIME_CHANNEL == 0 ? "red" : DensityImageExporter.PRIME_CHANNEL == 1 ? "green" : "blue";
        return String.format("NEW_highlighted_diagonals_%s_bias_%s_cutoff_%s_%s", RADIUS, PRIME_BIAS, CUTOFF, color);
    }


}
