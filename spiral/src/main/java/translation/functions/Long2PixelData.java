package translation.functions;

import export.PixelData;

import static math.PrimeUtils.isPrime;
import static math.PrimeUtils.isTwinPrime;
import static export.PixelData.*;

@FunctionalInterface
public interface Long2PixelData {

    PixelData calculatePixelValue(long[][] matrix, int i, int j);

    /**
     * Basic mapping function. Primes are mapped to black and composites to white pixels.
     */
    static Long2PixelData BASIC_BLACK_AND_WHITE() {
        return (matrix, i, j) -> {
            long value = matrix[i][j];
            if (value == 1) return RED;
            return isPrime(value) ? BLACK : WHITE;
        };
    }

    /**
     * Function that highlights twin primes. Twin primes are mapped to red, normal primes to black and composites to white.
     */
    static Long2PixelData HIGHLIGHT_TWIN_PRIMES() {
        return (matrix, i, j) -> {
            long value = matrix[i][j];
            if (isPrime(value)) {
                return isTwinPrime(value) ? RED : BLACK;
            } else {
                return WHITE;
            }
        };
    }

    /**
     * Basic density calculation function.
     */
    static Long2PixelData BASIC_DENSITY(int RED_BASE_VALUE, int GREEN_BASE_VALUE, int BLUE_BASE_VALUE, int PRIME_CHANNEL, int step) {
        return (matrix, i, j) -> {
            int pixelValue = (int) matrix[i][j] * step;

            int red = RED_BASE_VALUE;
            int green = GREEN_BASE_VALUE;
            int blue = BLUE_BASE_VALUE;

            if (PRIME_CHANNEL == 0) {
                red += pixelValue;
            } else if (PRIME_CHANNEL == 1) {
                green += pixelValue;
            } else if (PRIME_CHANNEL == 2) {
                blue += pixelValue;
            } else {
                throw new IllegalArgumentException("CHANNEL must be 0, 1, or 2");
            }

            red = Math.min(red, 255);
            green = Math.min(green, 255);
            blue = Math.min(blue, 255);

            return new PixelData(red, green, blue);
        };
    }



}
