package translation.functions;

import visualtization.PixelData;

import static math.PrimeUtils.isPrime;
import static math.PrimeUtils.isTwinPrime;
import static visualtization.PixelData.*;

@FunctionalInterface
public interface TranslationFunction {

    PixelData calculatePixelValue(long[][] matrix, int i, int j);

    /**
     * Basic mapping function. Primes are mapped to black and composites to white pixels.
     */
    static TranslationFunction BASIC_BLACK_AND_WHITE() {
        return (matrix, i, j) -> {
            long value = matrix[i][j];
            if (value == 1) return RED;
            return isPrime(value) ? BLACK : WHITE;
        };
    }

    /**
     * Function that highlights twin primes. Twin primes are mapped to red, normal primes to black and composites to white.
     */
    static TranslationFunction HIGHLIGHT_TWIN_PRIMES() {
        return (matrix, i, j) -> {
            long value = matrix[i][j];
            if (isPrime(value)) {
                return isTwinPrime(value) ? RED : BLACK;
            } else {
                return WHITE;
            }
        };
    }



}
