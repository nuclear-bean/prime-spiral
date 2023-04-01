package spiral.core.utils;

import lombok.experimental.UtilityClass;
import spiral.core.utils.annotations.ExternalCode;

@UtilityClass
@ExternalCode
public class Printer {

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

    private void iterateOverMatrix(long[][] matrix, int maxElementWidth) {
        for (int i = 0; i < matrix.length + 2; i++) {
            System.out.print("+");
            for (int j = 0; j < maxElementWidth; j++) {
                System.out.print("-");
            }
        }
        System.out.println("+");
    }

    public void printSimple(long[][] content) {
        for (long[] points : content) {
            for (long point : points) {
                System.out.print(String.valueOf(point) + '\t');
            }
            System.out.println();
        }
    }
}
