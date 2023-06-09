package spirals.ulam.examples;

import lombok.extern.log4j.Log4j2;
import spirals.ulam.generators.SimpleUlamGenerator;
import translation.MatrixTranslator;
import utils.export.OutputPathProvider;
import visualtization.DefaultImageExporter;
import visualtization.PixelData;

import java.io.File;
import java.io.IOException;

import static translation.functions.Long2PixelData.BASIC_BLACK_AND_WHITE;

/**
 * Creates basic Ulam spiral and saves it as spirals.ulam.export.image. Primes are mapped to black pixels, non-primes to white.
 */
@Log4j2
public class E01_BasicBlackAndWhite {

    private static final int SIZE = 501;

    public static void main(String[] args) throws IOException {
        long[][] matrix = generateBaseMatrix();
        PixelData[][] imageData = calculatePixelData(matrix);
        DefaultImageExporter.generateImage(imageData, getOutputFile());
    }

    private static File getOutputFile() {
        return new File(OutputPathProvider.getOutputPath("simple_black_and_white", SIZE, ".png", E01_BasicBlackAndWhite.class));
    }

    private static PixelData[][] calculatePixelData(long[][] matrix) {
        log.info("Calculating pixel data ...");
        return MatrixTranslator.translate(matrix, BASIC_BLACK_AND_WHITE());
    }

    private static long[][] generateBaseMatrix() {
        log.info("Generating base matrix ...");
        return SimpleUlamGenerator.generateMatrix(SIZE);
    }

}
