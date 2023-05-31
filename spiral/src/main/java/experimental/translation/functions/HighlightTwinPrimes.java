package experimental.translation.functions;

import experimental.visualtization.PixelData;

import static experimental.visualtization.PixelData.*;
import static math.PrimeUtils.isPrime;
import static math.PrimeUtils.isTwinPrime;

public class HighlightTwinPrimes implements TranslationFunction {

    @Override
    public PixelData calculatePixelValue(long[][] matrix, int i, int j) {
        long value = matrix[i][j];
        if (isPrime(value)) {
            return isTwinPrime(value) ? RED : BLUE;
        } else {
            return WHITE;
        }
    }

}
