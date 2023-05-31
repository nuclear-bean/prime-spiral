package experimental.translation.functions;

import experimental.visualtization.PixelData;

@FunctionalInterface
public interface TranslationFunction {

    void apply(long[][] matrix, PixelData[][] pixelData, int i, int j);

}
