package spiral.examples;

import lombok.extern.java.Log;
import spiral.core.matrix.Matrix;
import spiral.core.generator.BasicGenerator;
import spiral.core.image.BlackAndWhiteImageGenerator;
import spiral.examples.internals.ElapsedTimer;

/**
 * Creates basic Ulam spiral and saves it as image. Primes are mapped to black pixels, non-primes to white.
 */
@Log
public class BasicSpiralExample {

    private static int SIZE = 15001;
    private static String PATH = "ulam_spiral.png";

    public static void main(String[] args) {
        parseArgs(args);
        log.info("starting...");
        ElapsedTimer.start();
        log.info("generating matrix...");
        Matrix matrix = BasicGenerator.generateUlamSpiral(SIZE);
        log.info("generating image...");
        new BlackAndWhiteImageGenerator().generateImage(matrix.getContent(), PATH);
    }

    private static void parseArgs(String[] args) {
        if (args == null || args.length == 0) {
            return;
        }
        try {
            SIZE = Integer.parseInt(args[0]);
            PATH = args[1];
        } catch (NumberFormatException e) {
            log.warning("usage: java -jar spiral.jar <matrix_size> <output_path>");
            System.exit(1);
        }
    }
}
