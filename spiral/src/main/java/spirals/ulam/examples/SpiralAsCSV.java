package spirals.ulam.examples;

import export.csv.BasicCSVGenerator;
import lombok.extern.java.Log;
import spirals.ulam.generators.SimpleUlamGenerator;

import java.io.IOException;

@Log
public class SpiralAsCSV extends AbstractExample {

    public static void main(String[] args) throws IOException {
        PATH = "ulam_spiral.csv";
        SIZE = 1001;
        start(args);

        log.info("generating matrix...");
        long[][] matrix = SimpleUlamGenerator.generateMatrix(SIZE);

        log.info("generating csv...");
        BasicCSVGenerator.getInstance().generateCSV(matrix, PATH);
    }

}
