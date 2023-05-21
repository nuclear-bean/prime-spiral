package spirals.ulam.examples;

import lombok.extern.java.Log;
import image.BlackAndWhiteImageGenerator;
import spirals.ulam.generators.SimpleUlamGenerator;
import utils.ElapsedTimer;

/**
 * Creates basic Ulam spiral and saves it as image. Primes are mapped to black pixels, non-primes to white.
 */
@Log
public class BasicBlackAndWhiteExample {

    private static int SIZE = 15001;
    private static String PATH = "ulam_spiral.png";

    public static void main(String[] args) {
        parseArgs(args);
        log.info("starting...");
        ElapsedTimer.start();
        log.info("generating matrix...");
        long[][] matrix = SimpleUlamGenerator.generateMatrix(SIZE);
        log.info("generating image...");
        BlackAndWhiteImageGenerator.getInstance().generateImage(matrix, PATH);
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
