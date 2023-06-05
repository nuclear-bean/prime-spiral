package spirals.ulam.examples;

import lombok.extern.log4j.Log4j2;
import spirals.ulam.examples.abstracts.AbstractExample;
import spirals.ulam.export.csv.BasicCSVExporter;
import spirals.ulam.export.csv.SlimCSVExporter;
import spirals.ulam.generators.SimpleUlamGenerator;
import spirals.ulam.translators.generic.MatrixMappingFunction;
import utils.export.OutputPathProvider;
import matrix.MatrixMapper;

import java.io.IOException;

/**
 * Creates basic Ulam spiral and saves it as csv. Output file is a matrix of given size filled with 0s and 1s where 1 represents prime number and 0 represents non-prime number.
 */
@Log4j2
public class E03_ExportToSlimCSV {

    public static void main(String[] args) throws IOException {
        long[][] matrix = SimpleUlamGenerator.generateMatrix(501);
        boolean[][] booleanMapping = MatrixMapper.mapToBoolean(matrix);
        SlimCSVExporter.generateCSV(booleanMapping, OutputPathProvider.getOutputPath("ulam_slim", matrix.length, ".csv", E03_ExportToSlimCSV.class));
    }
}
