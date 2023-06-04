package spirals.ulam.examples;

import spirals.ulam.generators.SimpleUlamGenerator;
import translation.PixelDataTranslatorFacade;
import utils.export.OutputPathProvider;
import visualtization.DefaultImageExporter;
import visualtization.ImageExportException;
import visualtization.PixelData;

import java.io.File;

import static translation.functions.TranslationFunction.HIGHLIGHT_TWIN_PRIMES;

public class E08_HighlightTwinPrimes {

    public static void main(String[] args) throws ImageExportException {
        long[][] matrix = SimpleUlamGenerator.generateMatrix(2001);
        PixelData[][] imageData = PixelDataTranslatorFacade.translate(matrix, HIGHLIGHT_TWIN_PRIMES());
        new DefaultImageExporter().generateImage(imageData, new File(OutputPathProvider.getOutputPath("twin-primes", matrix.length, ".png", E08_HighlightTwinPrimes.class)));
    }

}
