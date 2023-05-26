package spirals.ulam.translators;

import math.PrimeUtils;

/**
 * Translates given matrix to binary matrix. Primes are mapped to 1, non-primes to 0.
 */
public final class BinaryTranslator {

    public static long[][] translate(long[][] matrix) {
        long[][] binaryMatrix = new long[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < binaryMatrix[i].length; j++) {
                if (PrimeUtils.isPrime(matrix[i][j])) {
                    binaryMatrix[i][j] = 1;
                } else {
                    binaryMatrix[i][j] = 0;
                }
            }
        }
        return binaryMatrix;
    }

    /**
     * @return binary matrix. Primes are mapped to true, non-primes to false.
     */
    public static boolean[][] translateToBoolean(long[][] matrix) {
        boolean[][] binaryMatrix = new boolean[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < binaryMatrix[i].length; j++) {
                binaryMatrix[i][j] = PrimeUtils.isPrime(matrix[i][j]);
            }
        }
        return binaryMatrix;
    }
}
