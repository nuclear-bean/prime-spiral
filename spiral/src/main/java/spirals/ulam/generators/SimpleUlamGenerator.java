package spirals.ulam.generators;

import utils.MatrixValidator;
import utils.annotations.ExternalCode;

/**
 * Not my code (Chat-GPT generated). It works, not very fast though.
 */
@ExternalCode
public final class SimpleUlamGenerator implements UlamGenerator {

    public static long[][] generateMatrix(int size) {
        return new SimpleUlamGenerator(size).generate();
    }

    private final long[][] matrix;

    public SimpleUlamGenerator(int size) {
        MatrixValidator.validateMatrixSize(size);
        this.matrix = new long[size][size];
    }

    @Override
    public long[][] generate() {
        ulamSpiralCounterClockwise();
        return matrix;
    }

    private void ulamSpiralCounterClockwise() {
        int row = matrix.length / 2; // start at the middle row
        int col = matrix.length / 2; // start at the middle column
        matrix[row][col] = 1; // put the number 1 in the middle of the matrix
        int currentNumber = 2; // start counting from 2
        int segmentLength = 1; // start with a segment of length 1
        int direction = 0; // start going to the right
        boolean ringCompleted = false;

        while (segmentLength < matrix.length || !ringCompleted) { // keep spiraling until the matrix is filled
            for (int i = 0; i < segmentLength; i++) { // iterate over the current segment
                if (ringCompleted && segmentLength >= matrix.length) break;
                switch (direction) { // move in the current direction
                    case 0 -> col++;        // go right
                    case 1 -> row++;        // go down
                    case 2 -> col--;        // go left
                    case 3 -> row--;        // go up
                }
                matrix[row][col] = currentNumber++; // fill in the next number in the sequence
                ringCompleted = isOddSquare(currentNumber - 1);
            }
            direction = (direction + 3) % 4; // turn clockwise
            if (direction == 0 || direction == 2) { // increase the segment length every other turn
                segmentLength++;
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
