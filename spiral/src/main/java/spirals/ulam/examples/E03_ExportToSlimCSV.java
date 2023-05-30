package spirals.ulam.examples;

import lombok.extern.log4j.Log4j2;
import spirals.ulam.examples.abstracts.AbstractExample;
import spirals.ulam.export.csv.SlimCSVExporter;
import spirals.ulam.translators.generic.MatrixMappingFunction;
import utils.export.OutputPathProvider;
import matrix.MatrixMapper;

import java.io.IOException;

/**
 * Creates basic Ulam spiral and saves it as csv. Output file is a matrix of given size filled with 0s and 1s where 1 represents prime number and 0 represents non-prime number.
 */
@Log4j2
public class E03_ExportToSlimCSV extends AbstractExample {

    public static void main(String[] args) {
        int size = 501;
        String outputPath = OutputPathProvider.getOutputPath("slim", size, ".csv", E03_ExportToSlimCSV.class);
        new E03_ExportToSlimCSV().run(size, outputPath);
    }

    @Override
    protected MatrixMappingFunction defineMatrixMappingFunction() {
        return (i,j,primeMap) -> {
            if (primeMap[i][j]) {
                return (short) 1;
            } else {
                return (short) 0;
            }
        };
    }

    @Override
    protected void generateImage(short[][] matrixMapping, String outputPath) {
        try {
            log.info("Generating csv...");
            boolean[][] primeMap = MatrixMapper.mapToBoolean(matrixMapping);
            SlimCSVExporter.generateCSV(primeMap, outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
