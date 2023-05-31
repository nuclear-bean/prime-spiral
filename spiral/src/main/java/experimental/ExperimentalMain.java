package experimental;

import experimental.translation.PixelDataTranslator;
import experimental.translation.functions.HighlightTwinPrimes;
import experimental.visualtization.DefaultImageExporter;
import experimental.visualtization.ImageExportException;
import experimental.visualtization.PixelData;
import spirals.ulam.generators.SimpleUlamGenerator;

import java.io.File;

public class ExperimentalMain {

    public static void main(String[] args) throws ImageExportException {
        long[][] matrix = SimpleUlamGenerator.generateMatrix(501);
        PixelData[][] imageData = PixelDataTranslator.translate(matrix, new HighlightTwinPrimes());
        new DefaultImageExporter().generateImage(imageData, new File("501.png"));
    }
}
