package spirals.ulam.examples;

import lombok.extern.java.Log;
import spirals.ulam.examples.abstracts.AbstractExample;
import spirals.ulam.export.image.BlackAndWhiteImageExporter;
import spirals.ulam.generators.SimpleUlamGenerator;

/**
 * Creates basic Ulam spiral and saves it as spirals.ulam.export.image. Primes are mapped to black pixels, non-primes to white.
 */
@Log
public class E01_BasicBlackAndWhite extends AbstractExample {

    public static void main(String[] args) {
        SIZE = 5001;
        PATH = "ulam_spiral_" + SIZE + ".png";
        prepare(args);

        log.info("generating matrix...");
        long[][] matrix = SimpleUlamGenerator.generateMatrix(SIZE);

        log.info("generating spirals.ulam.export.image...");
        BlackAndWhiteImageExporter.generateImage(matrix, PATH);
        log.info("generation completed");
    }
}
