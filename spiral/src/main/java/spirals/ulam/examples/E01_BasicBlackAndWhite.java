package spirals.ulam.examples;

import lombok.extern.log4j.Log4j2;
import spirals.ulam.examples.abstracts.AbstractExample;
import spirals.ulam.export.image.BlackAndWhiteImageExporter;
import spirals.ulam.generators.SimpleUlamGenerator;
import utils.ElapsedTimer;

/**
 * Creates basic Ulam spiral and saves it as spirals.ulam.export.image. Primes are mapped to black pixels, non-primes to white.
 */
@Log4j2
public class E01_BasicBlackAndWhite extends AbstractExample {

    public static void main(String[] args) {
        setup();
        long[][] matrix = generateMatrix();
        generateImage(matrix);
    }

    private static void generateImage(final long[][] matrix) {
        log.info("generating spirals.ulam.export.image...");
        BlackAndWhiteImageExporter.generateImage(matrix, PATH);
        log.info("generation completed");
    }

    private static long[][] generateMatrix() {
        log.info("generating matrix...");
        return SimpleUlamGenerator.generateMatrix(SIZE);
    }

    private static void setup() {
        log.info("starting...");
        ElapsedTimer.start();
        SIZE = 5001;
        PATH = "ulam_spiral_" + SIZE + ".png";
    }
}
