package spiral.core.utils;

import lombok.experimental.UtilityClass;
import spiral.core.utils.annotations.ExternalCode;

/**
 * Prints long[][] matrix to console
 */
@UtilityClass
@ExternalCode
public class ConsolePrinter {

    public void prettyPrintMatrixWithFrames(long[][] matrix) {
        // Determine the width of each matrix element for formatting purposes
        int maxElementWidth = Integer.toString(matrix.length * matrix[0].length).length() + 1;

        // Print the top frame
        iterateOverMatrix(matrix, maxElementWidth);

        // Print the matrix row by row with side frames
        for (long[] longs : matrix) {
            System.out.print("|");
            for (long aLong : longs) {
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
        if (matrix.length > 500) {
            System.out.println("Matrix is too big to print");
            return;
        }
        for (long[] points : matrix) {
            for (long point : points) {
                System.out.print(String.valueOf(point) + '\t');
            }
            System.out.println();
        }
    }

    private void iterateOverMatrix(long[][] matrix, int maxElementWidth) {
        for (int i = 0; i < matrix.length + 2; i++) {
            System.out.print("+");
            for (int j = 0; j < maxElementWidth; j++) {
                System.out.print("-");
            }
        }
        System.out.println("+");
    }
}
