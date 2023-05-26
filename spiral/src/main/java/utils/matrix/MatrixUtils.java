package utils.matrix;

import lombok.NonNull;

public class MatrixUtils {

    public static boolean safeIsTrue(@NonNull boolean[][] matrix, int i, int j) {
        try {
            return matrix[i][j];
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    /**
     * Converts a matrix of primitive shorts to a matrix of boxed Shorts.
     */
    public static Short[][] wrap(short [][] input) {
        Short[][] result = new Short[input.length][input.length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                result[i][j] = input[i][j];
            }
        }
        return result;
    }

    public static Long[][] wrap(long [][] input) {
        Long[][] result = new Long[input.length][input.length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                result[i][j] = input[i][j];
            }
        }
        return result;
    }

    public static Boolean[][] wrap(boolean[][] primeMapping) {
        Boolean[][] result = new Boolean[primeMapping.length][primeMapping.length];
        for (int i = 0; i < primeMapping.length; i++) {
            for (int j = 0; j < primeMapping.length; j++) {
                result[i][j] = primeMapping[i][j];
            }
        }
        return result;
    }

    public static short[][] unwrap(Short[][] result) {
        short[][] unwrapped = new short[result.length][result.length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                unwrapped[i][j] = result[i][j];
            }
        }
        return unwrapped;
    }

    public static long[][] unwrap(Long[][] result) {
        long[][] unwrapped = new long[result.length][result.length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                unwrapped[i][j] = result[i][j];
            }
        }
        return unwrapped;
    }
}
