package experimental.translation;

import experimental.translation.functions.TranslationFunction;
import experimental.visualtization.PixelData;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class PixelDataTranslator {

    public static PixelData[][] translate(long[][] matrix, TranslationFunction translationFunction) {
        PixelData[][] outputImageData = new PixelData[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                translationFunction.apply(matrix, outputImageData, i, j);
            }
        }
        return outputImageData;
    }

}
