package spirals.ulam.examples;

import lombok.extern.java.Log;
import spirals.ulam.export.image.DensityImageExporter;
import spirals.ulam.generators.SimpleUlamGenerator;
import spirals.ulam.translators.BinaryTranslator;
import spirals.ulam.translators.density.CustomizableDensityTranslator;
import spirals.ulam.translators.density.DensityTranslationSpec;

/**
 * Creates density representation of Ulam spiral and saves it as image. Density calculation strategy can be customized. See {@link DensityTranslationSpec} for more details.
 */
@Log
public class E05_CustomizableDensityRepresentation extends AbstractExample {

    public static void main(String[] args) {
        SIZE = 1001;
        PATH = "ulam_spiral_density_all_" + SIZE + ".png";

        DensityImageExporter.PRIME_CHANNEL = 2;

        DensityImageExporter.RED_BASE_VALUE = 10;
        DensityImageExporter.GREEN_BASE_VALUE = 0;
        DensityImageExporter.BLUE_BASE_VALUE = 50;

        start(args);

        log.info("generating matrix...");
        long[][] matrix = SimpleUlamGenerator.generateMatrix(SIZE);
        boolean[][] primeMapping = BinaryTranslator.translateToBoolean(matrix);

        DensityTranslationSpec spec = all(primeMapping);

        short[][] densityMapping = CustomizableDensityTranslator.translate(spec);
        log.info("generating spirals.ulam.export.image...");
        DensityImageExporter.generateImage(densityMapping, PATH);
        log.info("generation completed");
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
