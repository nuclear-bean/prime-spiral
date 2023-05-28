package spirals.ulam.examples;

import lombok.extern.log4j.Log4j2;
import spirals.ulam.examples.abstracts.AbstractExample;
import spirals.ulam.export.csv.BasicCSVExporter;
import spirals.ulam.translators.BinaryTranslator;
import spirals.ulam.translators.generic.MatrixMappingFunction;
import utils.OutputPathProvider;

import static utils.matrix.MatrixUtils.unwrap;

/**
 * Creates basic Ulam spiral and saves it as csv. Output file is a matrix of given size filled with 0s and 1s where 1 represents prime number and 0 represents non-prime number.
 */
@Log4j2
public class E02_ExportToCSV extends AbstractExample {

    public static void main(String[] args) {
        int size = 5_001;
        String outputPath = OutputPathProvider.getOutputPath("csv", size, ".csv", E02_ExportToCSV.class);
        new E02_ExportToCSV().run(size, outputPath);
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
    protected void generateImage(Short[][] matrixMapping, String outputPath) {
        log.info("Generating csv...");
        boolean[][] primeMap = BinaryTranslator.translateToBoolean(unwrap(matrixMapping));
        BasicCSVExporter.generateCSV(primeMap, outputPath);
    }
}
