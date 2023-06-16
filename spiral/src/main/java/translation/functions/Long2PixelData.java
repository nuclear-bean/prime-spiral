package translation.functions;

import export.image.PixelData;
import export.image.RGBChannel;

import static export.image.PixelData.*;
import static math.PrimeUtils.*;

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
     * Twin primes are mapped to black pixels. Everything else is mapped to white pixels.
     */
    static Long2PixelData TWIN_PRIMES_BLACK_AND_WHITE() {
        return (matrix, i, j) -> {
            long value = matrix[i][j];
            return isTwinPrime(value) ? BLACK : WHITE;
        };
    }

    /**
     * Cousin primes are mapped to black pixels. Everything else is mapped to white pixels.
     */
    static Long2PixelData COUSIN_PRIMES_BLACK_AND_WHITE() {
        return (matrix, i, j) -> {
            long value = matrix[i][j];
            return isCousinPrime(value) ? BLACK : WHITE;
        };
    }

    /**
     * Sexy primes are mapped to black pixels. Everything else is mapped to white pixels.
     */
    static Long2PixelData SEXY_PRIMES_BLACK_AND_WHITE() {
        return (matrix, i, j) -> {
            long value = matrix[i][j];
            return isSexyPrime(value) ? BLACK : WHITE;
        };
    }

    /**
     * Function that highlights primes that are neighbours of a given gap. Neighbour primes are mapped to black, isolated primes to black and composites to white.
     */
    static Long2PixelData PRIME_GAP_N(int gap) {
        return (matrix, i, j) -> {
            long value = matrix[i][j];
            return isNeighbourPrimeOfGap(value, gap) ? BLACK : WHITE;
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
    static Long2PixelData BASIC_DENSITY(int RED_BASE_VALUE, int GREEN_BASE_VALUE, int BLUE_BASE_VALUE, RGBChannel channel, int step) {
        return (matrix, i, j) -> {
            int pixelValue = (int) matrix[i][j] * step;

            int red = RED_BASE_VALUE;
            int green = GREEN_BASE_VALUE;
            int blue = BLUE_BASE_VALUE;

            switch (channel) {
                case RED -> red += pixelValue;
                case GREEN -> green += pixelValue;
                case BLUE -> blue += pixelValue;
            }

            red = Math.min(red, 255);
            green = Math.min(green, 255);
            blue = Math.min(blue, 255);

            return new PixelData(red, green, blue);
        };
    }
}
