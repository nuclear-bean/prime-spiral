package spirals.ulam.examples;

import lombok.extern.java.Log;
import export.image.BlackAndWhiteImageExporter;
import spirals.ulam.generators.SimpleUlamGenerator;

/**
 * Creates basic Ulam spiral and saves it as export.image. Primes are mapped to black pixels, non-primes to white.
 */
@Log
public class BasicBlackAndWhiteExample extends AbstractExample {

    public static void main(String[] args) {
        SIZE = 5001;
        PATH = "ulam_spiral_" + SIZE + ".png";
        start(args);

        log.info("generating matrix...");
        long[][] matrix = SimpleUlamGenerator.generateMatrix(SIZE);

        log.info("generating export.image...");
        BlackAndWhiteImageExporter.generateImage(matrix, PATH);
        log.info("generation completed");
    }
}
