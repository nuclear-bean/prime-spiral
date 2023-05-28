package spirals.ulam.examples.abstracts;

import lombok.extern.log4j.Log4j2;
import spirals.ulam.export.image.BinaryImageExporter;
import spirals.ulam.generators.SimpleUlamGenerator;
import spirals.ulam.translators.BinaryTranslator;
import spirals.ulam.translators.generic.GenericTranslator;
import spirals.ulam.translators.generic.MatrixMappingFunction;
import utils.ElapsedTimer;

import static utils.matrix.MatrixUtils.unwrap;
import static utils.matrix.MatrixUtils.wrap;

@Log4j2
public abstract class AbstractExample {

    protected void run(int size, String outputPath) {
        prepare(outputPath);
        long[][] matrix = generateMatrix(size);
        boolean[][] primeMapping = getPrimeMapping(matrix);
        MatrixMappingFunction mappingFunction = defineMatrixMappingFunction();
        Short[][] matrixMapping = getMapping(primeMapping, mappingFunction);
        generateImage(matrixMapping, outputPath);
    }

    protected void prepare(String outputPath) {
        log.info("Preparing... output will be saved to {}", outputPath);
        ElapsedTimer.start();
    }

    protected long[][] generateMatrix(int size) {
        log.info("Generating matrix...");
        return SimpleUlamGenerator.generateMatrix(size);
    }

    protected boolean[][] getPrimeMapping(long[][] matrix) {
        log.info("Generating prime mapping...");
        return BinaryTranslator.translateToBoolean(matrix);
    }

    protected Short[][] getMapping(boolean[][] primeMapping, MatrixMappingFunction mappingFunction) {
        log.info("Generating mapping...");
        return GenericTranslator.translate(wrap(primeMapping), mappingFunction);
    }

    protected void generateImage(Short[][] matrixMapping, String outputPath) {
        log.info("Generating image...");
        BinaryImageExporter.generateImage(unwrap(matrixMapping), outputPath);
    }

    protected abstract MatrixMappingFunction defineMatrixMappingFunction();

}
