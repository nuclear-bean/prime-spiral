package experimental.translation.functions;

import experimental.visualtization.PixelData;
import math.PrimeUtils;

public class HighlightTwinPrimes implements TranslationFunction {

    @Override
    public void apply(long[][] matrix, PixelData[][] pixelData, int i, int j) {
        long value = matrix[i][j];
        boolean prime = PrimeUtils.isPrime(value);

        if (value == 1) {
            pixelData[i][j] = PixelData.BLACK;
            return;
        }

        if (prime) {
            if (PrimeUtils.isTwinPrime(value)) {
                pixelData[i][j] = PixelData.RED;
            } else {
                pixelData[i][j] = PixelData.BLUE;
            }
        } else {
            pixelData[i][j] = PixelData.WHITE;
        }
    }

}
