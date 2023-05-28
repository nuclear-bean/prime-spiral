package spirals.ulam.utils;

import utils.matrix.MatrixMapper;

public class Validator {

    private static final Integer MIN_SIZE = 3;

    /**
     * Validates if given spiral size (side length) is valid. Throws IllegalArgumentException if not.
     *
     * @throws IllegalArgumentException if size is too small or even
     */
    public static void validateMatrixSize(int size) throws IllegalArgumentException {
        if (isTooSmall(size)) {
            throw new IllegalArgumentException(String.format("Spiral size should be at least %s", MIN_SIZE));
        }
        if (isEven(size)) {
            throw new IllegalArgumentException("Only odd spirals are allowed");
        }
    }

    public static void validateMatrix(short[][] matrix) throws IllegalArgumentException {
        long[][] longMatrix = MatrixMapper.shorts2longs(matrix);
        validateMatrix(longMatrix);
    }

    public static void validateMatrix(long[][] matrix) throws IllegalArgumentException {
        if (isSquareMatrix(matrix)) {
            throw new IllegalArgumentException("Spiral has to be a square matrix");
        }
        validateMatrixSize(matrix.length);
    }

    private static boolean isSquareMatrix(long[][] matrix) {
        return matrix.length != matrix[0].length;
    }

    private static boolean isEven(int size) {
        return size % 2 == 0;
    }

    private static boolean isTooSmall(int size) {
        return size < MIN_SIZE;
    }
}
