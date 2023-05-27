package spirals.ulam.examples;

import lombok.extern.log4j.Log4j2;
import spirals.ulam.examples.abstracts.SimplifiedAbstractExample;
import spirals.ulam.export.image.DensityImageExporter;
import spirals.ulam.translators.generic.MatrixMappingFunction;
import utils.OutputPathProvider;
import utils.matrix.MatrixUtils;
import utils.matrix.operations.MatrixContentOperations;

/**
 * Creates density representation of Ulam spiral and saves it as an image.
 */
@Log4j2
public class E04_DensityRepresentation extends SimplifiedAbstractExample {

    public static void main(String[] args) {
        int size = 1001;
        String outputPath = OutputPathProvider.getOutputPath("simple_density", size, ".png", E04_DensityRepresentation.class);
        new E04_DensityRepresentation().run(size, outputPath);
    }

    @Override
    protected void prepare(String outputPath) {
        super.prepare(outputPath);
        DensityImageExporter.PRIME_CHANNEL = 1;

        DensityImageExporter.RED_BASE_VALUE = 10;
        DensityImageExporter.GREEN_BASE_VALUE = 0;
        DensityImageExporter.BLUE_BASE_VALUE = 50;
    }

    @Override
    protected MatrixMappingFunction defineMatrixMappingFunction() {
        return (i, j, primeMap) ->
                (short) MatrixContentOperations.getCountOfTrueCellsWithinRadius(MatrixUtils.unwrap(primeMap), i, j, 1);
    }
    
    @Override
    protected void generateImage(Short[][] matrixMapping, String outputPath) {
        log.info("Generating image...");
        DensityImageExporter.generateImage(MatrixUtils.unwrap(matrixMapping), outputPath);
    }
}
