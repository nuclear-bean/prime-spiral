package spirals.ulam.examples;

import spirals.ulam.generators.SimpleUlamGenerator;
import translation.PixelDataTranslator;
import utils.export.OutputPathProvider;
import visualtization.PixelData;

import java.io.File;
import java.io.IOException;

import static translation.functions.TranslationFunction.HIGHLIGHT_TWIN_PRIMES;
import static visualtization.DefaultImageExporter.generateImage;

public class E08_HighlightTwinPrimes {

    public static void main(String[] args) throws IOException {
        long[][] matrix = SimpleUlamGenerator.generateMatrix(2001);
        PixelData[][] imageData = PixelDataTranslator.translate(matrix, HIGHLIGHT_TWIN_PRIMES());
        generateImage(imageData, new File(OutputPathProvider.getOutputPath("twin-primes", matrix.length, ".png", E08_HighlightTwinPrimes.class)));
    }

}
