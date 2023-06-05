package spirals.ulam.examples;

import lombok.extern.log4j.Log4j2;
import spirals.ulam.generators.SimpleUlamGenerator;
import translation.PixelDataTranslatorFacade;
import utils.export.OutputPathProvider;
import visualtization.DefaultImageExporter;
import visualtization.ImageExportException;
import visualtization.PixelData;

import java.io.File;

import static translation.functions.TranslationFunction.BASIC_BLACK_AND_WHITE;

/**
 * Creates basic Ulam spiral and saves it as spirals.ulam.export.image. Primes are mapped to black pixels, non-primes to white.
 */
@Log4j2
public class E01_BasicBlackAndWhite {

    public static void main(String[] args) throws ImageExportException {
        long[][] matrix = SimpleUlamGenerator.generateMatrix(501);
        PixelData[][] imageData = PixelDataTranslatorFacade.translate(matrix, BASIC_BLACK_AND_WHITE());
        new DefaultImageExporter().generateImage(imageData, new File(OutputPathProvider.getOutputPath("simple-black-and-white", matrix.length, ".png", E01_BasicBlackAndWhite.class)));
    }

}
