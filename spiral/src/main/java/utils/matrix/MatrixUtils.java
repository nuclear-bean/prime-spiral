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
    public static Short[][] mapToShort(short [][] input) {
        Short[][] result = new Short[input.length][input.length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                result[i][j] = input[i][j];
            }
        }
        return result;
    }
}
