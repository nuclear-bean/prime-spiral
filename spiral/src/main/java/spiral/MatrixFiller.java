package spiral;

import lombok.experimental.UtilityClass;

@SuppressWarnings("DuplicatedCode")
@UtilityClass
public class MatrixFiller {

    //todo rewrite matrix filler so it's understandable, works on rings etc.

    @ExternalCode
    public void ulamSpiralCounterClockwise(long[][] matrix) {
        int n = matrix.length; // get the size of the matrix
        int row = n / 2; // start at the middle row
        int col = n / 2; // start at the middle column
        matrix[row][col] = 1; // put the number 1 in the middle of the matrix
        int count = 2; // start counting from 2
        int length = 1; // start with a segment of length 1
        int direction = 0; // start going to the right
        boolean ringCompleted = false;

        while (length < n || !ringCompleted) { // keep spiraling until the matrix is filled
            for (int i = 0; i < length; i++) { // iterate over the current segment
                if (ringCompleted && length >= n) break;
                switch (direction) { // move in the current direction
                    case 0 -> col++;        // go right
                    case 1 -> row++;        // go down
                    case 2 -> col--;        // go left
                    case 3 -> row--;        // go up
                }
                matrix[row][col] = count++; // fill in the next number in the sequence
                ringCompleted = isOddSquare(count-1);
            }
            direction = (direction + 3) % 4; // turn clockwise
            if (direction == 0 || direction == 2) { // increase the segment length every other turn
                length++;
            }
        }
    }

    private boolean isOddSquare(int num) {
        // Check if the number is odd
        if (num % 2 == 0) {
            return false;
        }

        // Find the largest odd number whose square is less than or equal to the input number
        int n = 1;
        while (n * n <= num) {
            n += 2;
        }
        n -= 2;

        // Check if the input number is equal to the square of the odd number
        return n * n == num;
    }


    private void print(long[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    @ExternalCode
    private static void ulamSpiral(long[][] matrix) {
        int n = matrix.length; // get the size of the matrix
        int row = n / 2; // start at the middle row
        int col = n / 2; // start at the middle column
        matrix[row][col] = 1; // put the number 1 in the middle of the matrix
        int count = 2; // start counting from 2
        int length = 1; // start with a segment of length 1
        int direction = 0; // start going to the right


        while (length < n) { // keep spiraling until the matrix is filled
            for (int i = 0; i < length; i++) { // iterate over the current segment
                switch (direction) { // move in the current direction
                    case 0: col++; break; // to the right
                    case 1: row++; break; // down
                    case 2: col--; break; // to the left
                    case 3: row--; break; // up
                }
                matrix[row][col] = count++; // fill in the next number in the sequence
            }
            direction = (direction + 1) % 4; // turn clockwise
            if (direction == 0 || direction == 2) { // increase the segment length every other turn
                length++;
            }
        }
    }
}
