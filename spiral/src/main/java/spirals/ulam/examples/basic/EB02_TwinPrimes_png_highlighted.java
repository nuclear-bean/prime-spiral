package spirals.ulam.examples.basic;

import lombok.extern.log4j.Log4j2;
import spirals.ulam.generators.SimpleUlamGenerator;
import translation.MatrixTranslator;
import utils.ElapsedTimer;
import utils.export.OutputPathProvider;
import export.image.PixelData;

import java.io.File;
import java.io.IOException;

import static translation.functions.Long2PixelData.HIGHLIGHT_TWIN_PRIMES;
import static export.image.ImageExporter.generateImage;

@Log4j2
public class EB02_TwinPrimes_png_highlighted {

    private static final int SIZE = 1_001;

    public static void main(String[] args) throws IOException {
        ElapsedTimer.start();
        long[][] matrix = generateBaseMatrix();
        PixelData[][] imageData = calculatePixelData(matrix);
        generateImage(imageData, getOutputFile());
    }

    private static PixelData[][] calculatePixelData(long[][] matrix) {
        log.info("Calculating pixel data ...");
        return MatrixTranslator.translate(matrix, HIGHLIGHT_TWIN_PRIMES());
    }

    private static long[][] generateBaseMatrix() {
        log.info("Generating base matrix ...");
        return SimpleUlamGenerator.generateMatrix(SIZE);
    }

    private static File getOutputFile() {
        return new File(OutputPathProvider.getOutputPath("twin_primes_highlighted", SIZE, ".png", EB02_TwinPrimes_png_highlighted.class));
    }
}
