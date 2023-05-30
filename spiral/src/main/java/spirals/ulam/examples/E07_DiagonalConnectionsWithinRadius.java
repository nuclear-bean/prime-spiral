package spirals.ulam.examples;

import lombok.extern.log4j.Log4j2;
import spirals.ulam.examples.abstracts.AbstractExample;
import spirals.ulam.export.image.DensityImageExporter;
import spirals.ulam.translators.generic.MatrixMappingFunction;
import utils.export.OutputPathProvider;
import matrix.operations.MatrixContentOperations;

@Log4j2
public class E07_DiagonalConnectionsWithinRadius extends AbstractExample {

    private static int SIZE;
    private static int RADIUS;
    private static int PRIME_BIAS;
    private static int CUTOFF;  // don't highlight points with value below this number

    public static void main(String[] args) {
        setValues();
        String path = OutputPathProvider.getOutputPath(prepareFilename(), SIZE, ".png", E07_DiagonalConnectionsWithinRadius.class);
        new E07_DiagonalConnectionsWithinRadius().run(SIZE, path);
    }


    /**
     * Customize values here.
     */
    private static void setValues() {
        SIZE = 1_001;
        RADIUS = 10;
        PRIME_BIAS = 10;
        CUTOFF = 21;

        DensityImageExporter.PRIME_CHANNEL = 1;     //  0 - red, 1 - green, 2 - blue
        DensityImageExporter.RED_BASE_VALUE = 10;
        DensityImageExporter.GREEN_BASE_VALUE = 0;
        DensityImageExporter.BLUE_BASE_VALUE = 50;
    }

    private static String prepareFilename() {
        String color = DensityImageExporter.PRIME_CHANNEL == 0 ? "red" : DensityImageExporter.PRIME_CHANNEL == 1 ? "green" : "blue";
        return String.format("highlighted_diagonals_%s_bias_%s_cutoff_%s_%s", RADIUS, PRIME_BIAS, CUTOFF, color);
    }

    @Override
    protected void generateImage(short[][] matrixMapping, String outputPath) {
        log.info("Generating image...");
        DensityImageExporter.generateImage(matrixMapping, outputPath);
    }

    @Override
    protected MatrixMappingFunction defineMatrixMappingFunction() {
        return (i, j, matrix) -> {
            short value = (short) MatrixContentOperations.getDiagonalCountOfTrueCellsWithinRadius(matrix, i, j, RADIUS);
            if (matrix[i][j]) {
                value += PRIME_BIAS;
            }

            return value < CUTOFF ? 0 : value;
        };
    }
}
