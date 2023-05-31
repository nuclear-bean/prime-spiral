package experimental.translation.functions;

import experimental.visualtization.PixelData;

@FunctionalInterface
public interface TranslationFunction {

    PixelData calculatePixelValue(long[][] matrix, int i, int j);

}
