package spirals.ulam.examples;

import lombok.extern.java.Log;
import spirals.ulam.examples.abstracts.AbstractExample;
import spirals.ulam.export.csv.SlimCSVExporter;
import spirals.ulam.generators.SimpleUlamGenerator;

import java.io.IOException;

/**
 * Creates basic Ulam spiral and saves it as csv. Output file is a matrix of given size filled with 0s and 1s where 1 represents prime number and 0 represents non-prime number.
 */
@Log
public class E03_ExportToSlimCSV extends AbstractExample {

    public static void main(String[] args) throws IOException {
        SIZE = 1001;
        PATH = "ulam_spiral_" + SIZE + "_slim.csv";
        prepare(args);

        log.info("generating matrix...");
        long[][] matrix = SimpleUlamGenerator.generateMatrix(SIZE);

        log.info("generating csv...");
        SlimCSVExporter.generateCSV(matrix, PATH);
    }

}
