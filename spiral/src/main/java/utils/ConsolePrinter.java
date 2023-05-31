package utils;

import lombok.experimental.UtilityClass;
import utils.annotations.ExternalCode;

/**
 * Prints long[][] matrix to console
 */
@UtilityClass
@ExternalCode
public class ConsolePrinter {

    public <T extends Number> void prettyPrintMatrixWithFrames(T[][] matrix) {
        checkSize(matrix.length);

        // Determine the width of each matrix element for formatting purposes
        int maxElementWidth = Integer.toString(matrix.length * matrix[0].length).length() + 1;

        // Print the top frame
        iterateOverMatrix(matrix, maxElementWidth);

        // Print the matrix row by row with side frames
        for (T[] nums : matrix) {
            System.out.print("|");
            for (T aLong : nums) {
                // Format each matrix element to the desired width and print it
                System.out.printf("%-" + maxElementWidth + "d", aLong);
                System.out.print("|");
            }
            System.out.println(); // Move to the next row
        }

        // Print the bottom frame
        iterateOverMatrix(matrix, maxElementWidth);
    }

    public void printSimple(long[][] matrix) {
        checkSize(matrix.length);
        for (long[] row : matrix) {
            for (long point : row) {
                System.out.print(String.valueOf(point) + '\t');
            }
            System.out.println();
        }
    }

    private void checkSize(int size) {
        if (size > 500) {
            throw new IllegalArgumentException("Matrix is too big to print");
        }
    }

    private <T extends Number> void iterateOverMatrix(T[][] matrix, int maxElementWidth) {
        for (int i = 0; i < matrix.length + 2; i++) {
            System.out.print("+");
            for (int j = 0; j < maxElementWidth; j++) {
                System.out.print("-");
            }
        }
        System.out.println("+");
    }
}
