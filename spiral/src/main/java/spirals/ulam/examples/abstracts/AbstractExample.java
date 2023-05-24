package spirals.ulam.examples.abstracts;

import lombok.extern.java.Log;
import spirals.ulam.export.image.DensityImageExporter;
import utils.ElapsedTimer;

@Log
public class AbstractExample {

    protected static int SIZE = 15001;
    protected static String PATH;
    protected static String FILENAME;

    private static final String OUTPUT_DIR = "./output/";

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

    protected static String getPath() {
        return OUTPUT_DIR + SIZE + '_' + FILENAME + ".png";
    }
}
