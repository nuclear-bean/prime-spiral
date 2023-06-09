package spirals.ulam.examples;

import lombok.extern.log4j.Log4j2;
import spirals.ulam.export.csv.SlimCSVExporter;
import spirals.ulam.generators.SimpleUlamGenerator;
import translation.MatrixTranslator;
import translation.functions.Long2BooleanFunction;
import utils.export.OutputPathProvider;

import java.io.IOException;

/**
 * Creates basic Ulam spiral and saves it as csv. Output file is a matrix of given size filled with 0s and 1s where 1 represents prime number and 0 represents non-prime number.
 * Output file does not contain commas to save some space.
 */
@Log4j2
public class E03_ExportToSlimCSV {

    private static final int SIZE = 1001;

    public static void main(String[] args) throws IOException {
        long[][] matrix = generateBaseMatrix();
        boolean[][] booleanMapping = translateToBoolean(matrix);
        SlimCSVExporter.generateCSV(booleanMapping, getOutputPath());
    }

    private static boolean[][] translateToBoolean(long[][] matrix) {
        log.info("Translating to boolean matrix ...");
        return MatrixTranslator.translate(matrix, Long2BooleanFunction.PRIME);
    }

    private static long[][] generateBaseMatrix() {
        log.info("Generating base matrix ...");
        return SimpleUlamGenerator.generateMatrix(SIZE);
    }

    private static String getOutputPath() {
        return OutputPathProvider.getOutputPath("ulam_slim", SIZE, ".csv", E03_ExportToSlimCSV.class);
    }
}
