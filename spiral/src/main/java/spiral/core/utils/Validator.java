package spiral.core.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Validator {

    private final Integer MIN_SIZE = 3;

    public void validateMatrixSize(int size) throws IllegalArgumentException {
        if (isTooSmall(size)) {
            throw new IllegalArgumentException(String.format("Spiral size should be at least %s", MIN_SIZE));
        }
        if (isEven(size)) {
            throw new IllegalArgumentException("Only odd spirals are allowed");
        }
    }

    public void validateMatrixDimensions(long [][] matrix) throws IllegalArgumentException {
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
