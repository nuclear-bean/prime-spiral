package spirals.ulam.examples;

import lombok.extern.log4j.Log4j2;
import spirals.ulam.examples.abstracts.AbstractDensityExample;
import spirals.ulam.export.image.DensityImageExporter;
import spirals.ulam.generators.SimpleUlamGenerator;
import spirals.ulam.translators.BinaryTranslator;
import spirals.ulam.translators.density.DensitySpecification;
import spirals.ulam.translators.density.DensityTranslator;

/**
 * Creates density representation of Ulam spiral and saves it as image. Density calculation strategy can be customized.
 */
@Log4j2
public class E06_DensityWithRadiusAndBias extends AbstractDensityExample {

    private static int RADIUS;
    private static int PRIME_BIAS;

    @SuppressWarnings("CallToThreadRun")
    public static void main(String[] args) {
        new E06_DensityWithRadiusAndBias().run();
    }

    @Override
    protected void prepare() {
        SIZE = 501;
        RADIUS = 3;
        PRIME_BIAS = 15;
        FILENAME = "density_radius_" + RADIUS + "_bias_" + PRIME_BIAS + "_GREEN";

        DensityImageExporter.PRIME_CHANNEL = 1;

        DensityImageExporter.RED_BASE_VALUE = 10;
        DensityImageExporter.GREEN_BASE_VALUE = 0;
        DensityImageExporter.BLUE_BASE_VALUE = 50;
    }


    @Override
    protected short[][] mapMatrix(final long[][] matrix) {
        log.info("translating matrix to boolean...");
        boolean[][] primeMapping = BinaryTranslator.translateToBoolean(matrix);
        log.info("calculating density...");
        DensitySpecification spec = DensitySpecification.builder()
                .matrix(primeMapping)
                .radius(RADIUS)
                .primeBias(PRIME_BIAS)
                .build();
        return DensityTranslator.translate(spec);
    }

    protected long[][] generateMatrix() {
        log.info("generating matrix...");
        return SimpleUlamGenerator.generateMatrix(SIZE);
    }
}
