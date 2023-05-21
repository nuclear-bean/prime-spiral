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
        SIZE = 1003;
        PATH = "ulam_spiral_density_" + SIZE + ".png";

        start(args);

        log.info("generating matrix...");
        long[][] matrix = SimpleUlamGenerator.generateMatrix(SIZE);
        boolean[][] primeMapping = BinaryTranslator.translateToBoolean(matrix);
        short[][] densityMapping = DensityTranslator.translate(primeMapping);

        log.info("generating spirals.ulam.export.image...");
        DensityImageExporter.generateImage(densityMapping, PATH);
        log.info("generation completed");
    }
}
