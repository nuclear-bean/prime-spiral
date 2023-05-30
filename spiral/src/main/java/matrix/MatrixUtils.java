package matrix;

import lombok.NonNull;

public class MatrixUtils {

    public static boolean safeIsTrue(@NonNull boolean[][] matrix, int i, int j) {
        try {
            return matrix[i][j];
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }
}
