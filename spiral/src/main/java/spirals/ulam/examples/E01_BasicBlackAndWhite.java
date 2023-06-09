package spirals.ulam.examples;

import lombok.extern.log4j.Log4j2;
import spirals.ulam.generators.SimpleUlamGenerator;
import translation.PixelDataTranslator;
import utils.export.OutputPathProvider;
import visualtization.PixelData;

import java.io.File;
import java.io.IOException;

import static translation.functions.Long2PixelData.BASIC_BLACK_AND_WHITE;
import static visualtization.DefaultImageExporter.generateImage;

/**
 * Creates basic Ulam spiral and saves it as spirals.ulam.export.image. Primes are mapped to black pixels, non-primes to white.
 */
@Log4j2
public class E01_BasicBlackAndWhite {

    public static void main(String[] args) throws IOException {
        long[][] matrix = SimpleUlamGenerator.generateMatrix(501);
        PixelData[][] imageData = PixelDataTranslator.translate(matrix, BASIC_BLACK_AND_WHITE());
        generateImage(imageData, new File(OutputPathProvider.getOutputPath("simple-black-and-white", matrix.length, ".png", E01_BasicBlackAndWhite.class)));
    }

}
