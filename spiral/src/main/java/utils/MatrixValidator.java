package utils;

public final class MatrixValidator {

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

    private static boolean isTooSmall(int size) {
        return size < MIN_SIZE;
    }

    private static boolean isEven(int size) {
        return size % 2 == 0;
    }

}
