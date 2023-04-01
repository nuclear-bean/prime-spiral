package spiral;

import lombok.experimental.UtilityClass;

@UtilityClass
@ExternalCode
public class Printer {

    public static void prettyPrintMatrixWithFrames(long[][] matrix) {
        // Determine the width of each matrix element for formatting purposes
        int maxElementWidth = Integer.toString(matrix.length * matrix[0].length).length() + 1;

        // Print the top frame
        iterate(matrix, maxElementWidth);

        // Print the matrix row by row with side frames
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("|");
            for (int j = 0; j < matrix[i].length; j++) {
                // Format each matrix element to the desired width and print it
                System.out.printf("%-" + maxElementWidth + "d", matrix[i][j]);
                System.out.print("|");
            }
            System.out.println(); // Move to the next row
        }

        // Print the bottom frame
        iterate(matrix, maxElementWidth);
    }

    private static void iterate(long[][] matrix, int maxElementWidth) {
        for (int i = 0; i < matrix.length + 2; i++) {
            System.out.print("+");
            for (int j = 0; j < maxElementWidth; j++) {
                System.out.print("-");
            }
        }
        System.out.println("+");
    }

}
