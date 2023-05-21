package spirals.ulam.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Validator {

    private final Integer MIN_SIZE = 3;

    /**
     * Validates if given spiral size (side length) is valid. Throws IllegalArgumentException if not.
     * @throws IllegalArgumentException if size is too small or even
     */
    public void validateMatrixSize(int size) throws IllegalArgumentException {
        if (isTooSmall(size)) {
            throw new IllegalArgumentException(String.format("Spiral size should be at least %s", MIN_SIZE));
        }
        if (isEven(size)) {
            throw new IllegalArgumentException("Only odd spirals are allowed");
        }
    }

    public void validateMatrix(short [][] matrix) throws IllegalArgumentException {
        long[][] longMatrix = mapToLongs(matrix);
        validateMatrix(longMatrix);
    }

    private long[][] mapToLongs(short[][] matrix) {
        long [][] longMatrix = new long[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < longMatrix[i].length; j++) {
                longMatrix[i][j] = matrix[i][j];
            }
        }
        return longMatrix;
    }

    public void validateMatrix(long [][] matrix) throws IllegalArgumentException {
        if (isSquareMatrix(matrix)) {
            throw new IllegalArgumentException("Spiral has to be a square matrix");
        }
        validateMatrixSize(matrix.length);
    }

    private boolean isSquareMatrix(long[][] matrix) {
        return matrix.length != matrix[0].length;
    }

    private static boolean isEven(int size) {
        return size % 2 == 0;
    }

    private static boolean isTooSmall(int size) {
        return size < MIN_SIZE;
    }
}
