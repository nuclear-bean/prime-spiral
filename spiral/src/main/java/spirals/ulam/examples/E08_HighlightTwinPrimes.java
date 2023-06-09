package spirals.ulam.examples;

import spirals.ulam.generators.SimpleUlamGenerator;
import translation.MatrixTranslator;
import utils.export.OutputPathProvider;
import visualtization.PixelData;

import java.io.File;
import java.io.IOException;

import static translation.functions.Long2PixelData.HIGHLIGHT_TWIN_PRIMES;
import static visualtization.DefaultImageExporter.generateImage;

public class E08_HighlightTwinPrimes {

    public static void main(String[] args) throws IOException {
        long[][] matrix = SimpleUlamGenerator.generateMatrix(2001);
        PixelData[][] imageData = MatrixTranslator.translate(matrix, HIGHLIGHT_TWIN_PRIMES());
        generateImage(imageData, new File(OutputPathProvider.getOutputPath("twin-primes", matrix.length, ".png", E08_HighlightTwinPrimes.class)));
    }

}
