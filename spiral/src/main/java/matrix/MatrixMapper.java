package matrix;

import lombok.NoArgsConstructor;
import math.PrimeUtils;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public final class MatrixMapper {

    /**
     * @return long matrix. Simple type conversion.
     */
    public static long[][] shorts2longs(short[][] matrix) {
        long[][] longMatrix = new long[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < longMatrix[i].length; j++) {
                longMatrix[i][j] = matrix[i][j];
            }
        }
        return longMatrix;
    }

    /**
     * @return boolean matrix. Primes are mapped to true, composites to false.
     * @throws IllegalArgumentException if matrix contains anything but 1s and 0s
     */
    public static boolean[][] mapToBoolean(long[][] matrix) {
        boolean[][] binaryMatrix = new boolean[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < binaryMatrix[i].length; j++) {
                binaryMatrix[i][j] = PrimeUtils.isPrime(matrix[i][j]);
            }
        }
        return binaryMatrix;
    }
}
