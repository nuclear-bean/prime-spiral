package utils;

import utils.annotations.ExternalCode;

/**
 * Prints long[][] matrix to console
 */
@ExternalCode
public class ConsolePrinter {

    private static final int MAX_MATRIX_SIZE = 500;

    public static void printSimple(long[][] matrix) {
        checkSize(matrix.length);
        for (long[] row : matrix) {
            for (long point : row) {
                System.out.print(String.valueOf(point) + '\t');
            }
            System.out.println();
        }
    }

    private static void checkSize(int size) {
        if (size > MAX_MATRIX_SIZE) {
            throw new IllegalArgumentException("Matrix is too big to print");
        }
    }
}
