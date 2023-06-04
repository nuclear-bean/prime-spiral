package translation.functions;

import visualtization.PixelData;

import static math.PrimeUtils.isPrime;
import static math.PrimeUtils.isTwinPrime;
import static visualtization.PixelData.*;

@FunctionalInterface
public interface TranslationFunction {

    PixelData calculatePixelValue(long[][] matrix, int i, int j);

    static TranslationFunction HIGHLIGHT_TWIN_PRIMES() {
        return (matrix, i, j) -> {
            long value = matrix[i][j];
            if (isPrime(value)) {
                return isTwinPrime(value) ? RED : BLUE;
            } else {
                return WHITE;
            }
        };
    }

}
