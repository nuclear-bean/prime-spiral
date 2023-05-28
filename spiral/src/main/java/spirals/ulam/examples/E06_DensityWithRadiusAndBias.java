package spirals.ulam.examples;

import lombok.extern.log4j.Log4j2;
import spirals.ulam.examples.abstracts.AbstractExample;
import spirals.ulam.export.image.DensityImageExporter;
import spirals.ulam.translators.generic.MatrixMappingFunction;
import utils.export.OutputPathProvider;
import utils.matrix.operations.MatrixContentOperations;

/**
 * Creates density representation of Ulam spiral and saves it as image. Density calculation strategy can be customized.
 */
@Log4j2
public class E06_DensityWithRadiusAndBias extends AbstractExample {

    private static int SIZE;
    private static int RADIUS;
    private static int PRIME_BIAS;

    public static void main(String[] args) {
        setValues();
        String path = OutputPathProvider.getOutputPath(prepareFilename(), SIZE, ".png", E06_DensityWithRadiusAndBias.class);
        new E06_DensityWithRadiusAndBias().run(SIZE, path);
    }

    /**
     * Customize values here.
     */
    private static void setValues() {
        SIZE = 1001;
        RADIUS = 1;
        PRIME_BIAS = 0;
        DensityImageExporter.PRIME_CHANNEL = 1;     //  0 - red, 1 - green, 2 - blue
        DensityImageExporter.RED_BASE_VALUE = 10;
        DensityImageExporter.GREEN_BASE_VALUE = 0;
        DensityImageExporter.BLUE_BASE_VALUE = 50;
    }

    private static String prepareFilename() {
        return String.format("density_radius_%s_bias_%s", RADIUS, PRIME_BIAS);
    }

    @Override
    protected MatrixMappingFunction defineMatrixMappingFunction() {
        return (i, j, matrix) -> {
            short value = (short) MatrixContentOperations.getCountOfTrueCellsWithinRadius(matrix, i, j, RADIUS);
            if (matrix[i][j]) {
                value += PRIME_BIAS;
            }
            return value;
        };
    }

    @Override
    protected void generateImage(short[][] matrixMapping, String outputPath) {
        log.info("Generating image...");
        DensityImageExporter.generateImage(matrixMapping, outputPath);
    }
}
