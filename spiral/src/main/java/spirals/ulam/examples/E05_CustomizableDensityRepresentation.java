package spirals.ulam.examples;

import lombok.extern.log4j.Log4j2;
import spirals.ulam.export.image.DensityImageExporter;
import spirals.ulam.generators.SimpleUlamGenerator;
import spirals.ulam.translators.BinaryTranslator;
import spirals.ulam.translators.density.CustomizableDensityTranslator;
import spirals.ulam.translators.density.DensityTranslationSpec;

/**
 * Creates density representation of Ulam spiral and saves it as image. Density calculation strategy can be customized. See {@link DensityTranslationSpec} for more details.
 */
@Log4j2
public class E05_CustomizableDensityRepresentation extends AbstractDensityExample {

    @SuppressWarnings("CallToThreadRun")
    public static void main(String[] args) {
        new E05_CustomizableDensityRepresentation().run();
    }

    @Override
    protected short[][] mapMatrix(final long[][] matrix) {
        boolean[][] primeMapping = BinaryTranslator.translateToBoolean(matrix);
        DensityTranslationSpec spec = onlyDiagonalDensity(primeMapping);        // change this line to try different density calculation strategies
        return CustomizableDensityTranslator.translate(spec);
    }

    @Override
    protected long[][] generateMatrix() {
        log.info("generating matrix...");
        return SimpleUlamGenerator.generateMatrix(SIZE);
    }

    @Override
    protected void prepare() {
        SIZE = 1001;
        FILENAME = "spiral_density_all_";

        DensityImageExporter.PRIME_CHANNEL = 2;

        DensityImageExporter.RED_BASE_VALUE = 10;
        DensityImageExporter.GREEN_BASE_VALUE = 0;
        DensityImageExporter.BLUE_BASE_VALUE = 50;
    }

    private static DensityTranslationSpec excludeDiagonalDensity(boolean[][] primeMapping) {
        DensityTranslationSpec spec = DensityTranslationSpec.builder().matrix(primeMapping).build();
        spec.setAll(true);
        spec.setDiagonals(false);
        return spec;
    }

    private static DensityTranslationSpec onlyDiagonalDensity(boolean[][] primeMapping) {
        DensityTranslationSpec spec = DensityTranslationSpec.builder().matrix(primeMapping).build();
        spec.setAll(false);
        spec.setDiagonals(true);
        return spec;
    }

    private static DensityTranslationSpec all(boolean[][] primeMapping) {
        DensityTranslationSpec spec = DensityTranslationSpec.builder().matrix(primeMapping).build();
        spec.setAll(true);
        return spec;
    }
}
