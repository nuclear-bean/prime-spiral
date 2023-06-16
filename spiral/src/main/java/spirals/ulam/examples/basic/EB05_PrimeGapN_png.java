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

import static translation.functions.Long2PixelData.PRIME_GAP_N;

@Log4j2
public class EB05_PrimeGapN_png {

    private static final int SIZE = 1_001;
    private static final int GAP = 42;

    public static void main(String[] args) throws IOException {
        ElapsedTimer.start();
        long[][] matrix = generateBaseMatrix();
        PixelData[][] imageData = calculatePixelData(matrix);
        ImageExporter.generateImage(imageData, getOutputFile());
    }

    private static PixelData[][] calculatePixelData(long[][] matrix) {
        log.info("Calculating pixel data ...");
        return MatrixTranslator.translate(matrix, PRIME_GAP_N(GAP));
    }

    private static long[][] generateBaseMatrix() {
        log.info("Generating base matrix ...");
        return SimpleUlamGenerator.generateMatrix(SIZE);
    }

    private static File getOutputFile() {
        return new File(OutputPathProvider.prepareOutputPath(String.format("prime_gap_%s", GAP), SIZE, ".png", EB05_PrimeGapN_png.class));
    }
}
