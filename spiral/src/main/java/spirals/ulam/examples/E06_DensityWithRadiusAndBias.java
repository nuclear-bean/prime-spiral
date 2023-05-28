package spirals.ulam.examples;

import lombok.extern.log4j.Log4j2;
import spirals.ulam.examples.abstracts.AbstractExample;
import spirals.ulam.export.image.DensityImageExporter;
import spirals.ulam.translators.generic.MatrixMappingFunction;
import utils.OutputPathProvider;
import utils.matrix.MatrixUtils;
import utils.matrix.operations.MatrixContentOperations;

/**
 * Creates density representation of Ulam spiral and saves it as image. Density calculation strategy can be customized.
 */
@Log4j2
public class E06_DensityWithRadiusAndBias extends AbstractExample {

    private static int RADIUS;
    private static int PRIME_BIAS;

    public static void main(String[] args) {
        int SIZE = 501;
        RADIUS = 3;
        PRIME_BIAS = 15;
        String path = OutputPathProvider.getOutputPath(
                String.format("new_density_radius_%s_bias_%s", RADIUS, PRIME_BIAS), SIZE, ".png", E06_DensityWithRadiusAndBias.class);
        new E06_DensityWithRadiusAndBias().run(SIZE, path);
    }

    @Override
    protected void prepare(String outputPath) {
        super.prepare(outputPath);

        DensityImageExporter.PRIME_CHANNEL = 1;

        DensityImageExporter.RED_BASE_VALUE = 10;
        DensityImageExporter.GREEN_BASE_VALUE = 0;
        DensityImageExporter.BLUE_BASE_VALUE = 50;
    }

    @Override
    protected MatrixMappingFunction defineMatrixMappingFunction() {
        return (i, j, matrix) -> {
            short value = (short) MatrixContentOperations.getCountOfTrueCellsWithinRadius(MatrixUtils.unwrap(matrix), i, j, RADIUS);
            value = applyPrimeBias(i, j, matrix, value);
            return value;
        };
    }

    private short applyPrimeBias(int i, int j, Boolean[][] matrix, short value) {
        if (matrix[i][j]) {
            value += PRIME_BIAS;
        }
        return value;
    }

    @Override
    protected void generateImage(Short[][] matrixMapping, String outputPath) {
        log.info("Generating image...");
        DensityImageExporter.generateImage(MatrixUtils.unwrap(matrixMapping), outputPath);
    }
}
