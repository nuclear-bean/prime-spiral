package spirals.ulam.examples;

import lombok.extern.log4j.Log4j2;
import spirals.ulam.examples.abstracts.AbstractExample;
import spirals.ulam.export.csv.SlimCSVExporter;
import spirals.ulam.generators.SimpleUlamGenerator;
import spirals.ulam.translators.BinaryTranslator;
import utils.ElapsedTimer;

import java.io.IOException;

/**
 * Creates basic Ulam spiral and saves it as csv. Output file is a matrix of given size filled with 0s and 1s where 1 represents prime number and 0 represents non-prime number.
 */
@Log4j2
public class E03_ExportToSlimCSV extends AbstractExample {

    public static void main(String[] args) throws IOException {
        setup();
        long[][] matrix = generateMatrix();
        boolean[][] primeMapping = translateToBinaryMatrix(matrix);
        generateCSV(primeMapping);
    }

    private static void generateCSV(final boolean[][] primeMapping) throws IOException {
        log.info("generating csv...");
        SlimCSVExporter.generateCSV(primeMapping, PATH);
    }

    private static boolean[][] translateToBinaryMatrix(final long[][] matrix) {
        log.info("translating matrix to boolean...");
        return BinaryTranslator.translateToBoolean(matrix);
    }

    private static long[][] generateMatrix() {
        log.info("generating matrix...");
        return SimpleUlamGenerator.generateMatrix(SIZE);
    }

    private static void setup() {
        log.info("starting...");
        ElapsedTimer.start();
        SIZE = 1001;
        PATH = "ulam_spiral_" + SIZE + "_slim.csv";
    }
}
