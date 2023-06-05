package spirals.ulam.examples.abstracts;

import lombok.extern.log4j.Log4j2;
import spirals.ulam.export.image.BinaryImageExporter;
import spirals.ulam.generators.SimpleUlamGenerator;
import spirals.ulam.translators.BinaryTranslator;
import spirals.ulam.translators.generic.GenericTranslator;
import spirals.ulam.translators.generic.MatrixMappingFunction;
import utils.ElapsedTimer;

@Deprecated(forRemoval = true)
@Log4j2
public abstract class AbstractExample {

    protected void run(int size, String outputPath) {
        prepare(outputPath);
        long[][] matrix = generateMatrix(size);
        boolean[][] primeMapping = getPrimeMapping(matrix);
        MatrixMappingFunction mappingFunction = defineMatrixMappingFunction();
        short[][] matrixMapping = getMapping(primeMapping, mappingFunction);
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

    protected short[][] getMapping(boolean[][] primeMapping, MatrixMappingFunction mappingFunction) {
        log.info("Generating mapping...");
        return GenericTranslator.translate(primeMapping, mappingFunction);
    }

    protected void generateImage(short[][] matrixMapping, String outputPath) {
        log.info("Generating image...");
        BinaryImageExporter.generateImage(matrixMapping, outputPath);
    }

    protected abstract MatrixMappingFunction defineMatrixMappingFunction();

}
