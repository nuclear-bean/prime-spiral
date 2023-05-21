package spirals.ulam.examples;

import lombok.extern.java.Log;
import export.image.BlackAndWhiteImageGenerator;
import spirals.ulam.generators.SimpleUlamGenerator;

/**
 * Creates basic Ulam spiral and saves it as export.image. Primes are mapped to black pixels, non-primes to white.
 */
@Log
public class BasicBlackAndWhiteExample extends AbstractExample {

    public static void main(String[] args) {
        start(args);

        log.info("generating matrix...");
        long[][] matrix = SimpleUlamGenerator.generateMatrix(SIZE);

        log.info("generating export.image...");
        BlackAndWhiteImageGenerator.getInstance().generateImage(matrix, PATH);
    }
}
