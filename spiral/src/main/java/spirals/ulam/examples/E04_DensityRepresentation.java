package spirals.ulam.examples;

import spirals.ulam.export.image.DensityImageExporter;
import lombok.extern.java.Log;
import spirals.ulam.generators.SimpleUlamGenerator;
import spirals.ulam.translators.BinaryTranslator;
import spirals.ulam.translators.density.DensityTranslator;

/**
 * Creates density representation of Ulam spiral and saves it as image.
 */
@Log
public class E04_DensityRepresentation extends AbstractExample {

    public static void main(String[] args) {
        SIZE = 501;
        PATH = SIZE + "_old_density_simple_radius_1" + ".png";

        DensityImageExporter.PRIME_CHANNEL = 2;

        DensityImageExporter.RED_BASE_VALUE = 10;
        DensityImageExporter.GREEN_BASE_VALUE = 0;
        DensityImageExporter.BLUE_BASE_VALUE = 50;

        prepare(args);

        log.info("generating matrix...");
        long[][] matrix = SimpleUlamGenerator.generateMatrix(SIZE);
        log.info("translating matrix to boolean...");
        boolean[][] primeMapping = BinaryTranslator.translateToBoolean(matrix);
        log.info("calculating density...");
        short[][] densityMapping = DensityTranslator.translate(primeMapping);

        log.info("generating spirals.ulam.export.image...");
        DensityImageExporter.generateImage(densityMapping, PATH);
        log.info("generation completed");
    }
}
