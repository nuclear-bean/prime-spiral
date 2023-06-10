package spirals.ulam.examples;

import export.ImageExporter;
import export.PixelData;
import lombok.extern.log4j.Log4j2;
import spirals.ulam.generators.SimpleUlamGenerator;
import translation.MatrixTranslator;
import utils.export.OutputPathProvider;

import java.io.File;
import java.io.IOException;

import static translation.functions.Long2PixelData.BASIC_BLACK_AND_WHITE;
import static translation.functions.Long2PixelData.TWIN_PRIMES_BLACK_AND_WHITE;

/**
 * Creates basic Ulam spiral and saves it as spirals.ulam.export.image. Primes are mapped to black pixels, non-primes to white.
 */
@Log4j2
public class E04_TwinPrimesBlackAndWhite {

    private static final int SIZE = 501;

    public static void main(String[] args) throws IOException {
        long[][] matrix = generateBaseMatrix();
        PixelData[][] imageData = calculatePixelData(matrix);
        ImageExporter.generateImage(imageData, getOutputFile());
    }

    private static PixelData[][] calculatePixelData(long[][] matrix) {
        log.info("Calculating pixel data ...");
        return MatrixTranslator.translate(matrix, TWIN_PRIMES_BLACK_AND_WHITE());
    }

    private static long[][] generateBaseMatrix() {
        log.info("Generating base matrix ...");
        return SimpleUlamGenerator.generateMatrix(SIZE);
    }

    private static File getOutputFile() {
        return new File(OutputPathProvider.getOutputPath("simple_black_and_white", SIZE, ".png", E04_TwinPrimesBlackAndWhite.class));
    }

}
