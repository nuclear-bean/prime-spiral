package spirals.ulam.examples;

import lombok.extern.log4j.Log4j2;
import matrix.MatrixMapper;
import spirals.ulam.export.csv.BasicCSVExporter;
import spirals.ulam.generators.SimpleUlamGenerator;
import utils.export.OutputPathProvider;

/**
 * Creates basic Ulam spiral and saves it as csv. Output file is a matrix of given size filled with 0s and 1s where 1 represents prime number and 0 represents a composite number.
 */
@Log4j2
public class E02_ExportToCSV {

    public static void main(String[] args) {
        long[][] matrix = SimpleUlamGenerator.generateMatrix(1001);
        boolean[][] booleanMapping = MatrixMapper.mapToBoolean(matrix);
        BasicCSVExporter.generateCSV(booleanMapping, OutputPathProvider.getOutputPath("ulam", matrix.length, ".csv", E02_ExportToCSV.class));
    }
}
