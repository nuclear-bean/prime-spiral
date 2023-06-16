package spirals.ulam.examples.basic;

import export.image.ImageExporter;
import export.image.PixelData;
import lombok.extern.log4j.Log4j2;
import spirals.ulam.generators.SimpleUlamGenerator;
import translation.MatrixTranslator;
import utils.ElapsedTimer;
import utils.export.OutputPathProvider;

import java.io.File;
import java.io.IOException;

import static translation.functions.Long2PixelData.SEXY_PRIMES_BLACK_AND_WHITE;

@Log4j2
public class EB04_SexyPrimes_png {

    private static final int SIZE = 1_001;

    public static void main(String[] args) throws IOException {
        ElapsedTimer.start();
        long[][] matrix = generateBaseMatrix();
        PixelData[][] imageData = calculatePixelData(matrix);
        ImageExporter.generateImage(imageData, getOutputFile());
    }

    private static PixelData[][] calculatePixelData(long[][] matrix) {
        log.info("Calculating pixel data ...");
        return MatrixTranslator.translate(matrix, SEXY_PRIMES_BLACK_AND_WHITE());
    }

    private static long[][] generateBaseMatrix() {
        log.info("Generating base matrix ...");
        return SimpleUlamGenerator.generateMatrix(SIZE);
    }

    private static File getOutputFile() {
        return new File(OutputPathProvider.getOutputPath("sexy_primes", SIZE, ".png", EB04_SexyPrimes_png.class));
    }

}
