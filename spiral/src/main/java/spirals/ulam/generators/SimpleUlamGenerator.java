package spirals.ulam.generators;

import lombok.experimental.UtilityClass;
import utils.annotations.Experimental;
import utils.annotations.ExternalCode;
import spirals.ulam.utils.Validator;

@SuppressWarnings("DuplicatedCode")
@UtilityClass
@Experimental
@ExternalCode
public class SimpleUlamGenerator {

    public long[][] generateMatrix(int size) {
        Validator.validateMatrixSize(size);
        long[][] matrix = new long[size][size];
        ulamSpiralCounterClockwise(matrix);
        return matrix;
    }

    private void ulamSpiralCounterClockwise(long[][] matrix) {
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
                ringCompleted = isOddSquare(count - 1);
            }
            direction = (direction + 3) % 4; // turn clockwise
            if (direction == 0 || direction == 2) { // increase the segment length every other turn
                length++;
            }
        }
    }

    private boolean isOddSquare(int num) {
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
}
