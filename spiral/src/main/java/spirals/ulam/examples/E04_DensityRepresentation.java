package spirals.ulam.examples;

import lombok.extern.java.Log;
import spirals.ulam.examples.abstracts.AbstractDensityExample;
import spirals.ulam.export.image.DensityImageExporter;
import spirals.ulam.generators.SimpleUlamGenerator;
import spirals.ulam.translators.BinaryTranslator;
import spirals.ulam.translators.density.DensitySpecification;
import spirals.ulam.translators.density.DensityTranslator;

/**
 * Creates density representation of Ulam spiral and saves it as an image.
 */
@Log
public class E04_DensityRepresentation extends AbstractDensityExample {

    @SuppressWarnings("CallToThreadRun")
    public static void main(String[] args) {
        new E04_DensityRepresentation().run();
    }

    @Override
    protected void prepare() {
        SIZE = 1001;
        FILENAME = "density_simple_green";

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
        DensitySpecification specification = DensitySpecification.builder().matrix(primeMapping).build();
        return DensityTranslator.translate(specification);
    }

    @Override
    protected long[][] generateMatrix() {
        log.info("generating matrix...");
        return SimpleUlamGenerator.generateMatrix(SIZE);
    }
}
