package translation;

import groovy.util.logging.Slf4j;
import translation.functions.TranslationFunction;
import visualtization.PixelData;
import lombok.NoArgsConstructor;

import java.time.Instant;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class PixelDataTranslator {

    private static Instant lastLog = Instant.now(); // todo SRP violation
    private static Instant nextLog = Instant.now();

    public static PixelData[][] translate(long[][] matrix, TranslationFunction function) {
        PixelData[][] outputImageData = new PixelData[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                logProgress(i,j,matrix.length);
                outputImageData[i][j] = function.calculatePixelValue(matrix, i, j);
            }
        }
        return outputImageData;
    }

    private static void logProgress(int i, int j, int length) {
        //todo SRP violation
    }

    private static void doLog(int i, int j, int length) {
        int current = (i * length) + j;
        double progress = (current*100) / (double) length;
        System.out.println("translating matrix... progress: " + progress + " %");
    }

}
