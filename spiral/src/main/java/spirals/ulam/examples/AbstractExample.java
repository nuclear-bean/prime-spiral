package spirals.ulam.examples;

import lombok.extern.java.Log;
import utils.ElapsedTimer;

@Log
public class AbstractExample {

    protected static int SIZE = 15001;
    protected static String PATH = "ulam_spiral.png";

    protected static void prepare(String [] args) {
        parseArgs(args);
        log.info("starting...");
        ElapsedTimer.start();
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
