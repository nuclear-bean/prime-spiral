package spirals.ulam.generators;

import spirals.ulam.calculators.SpokeValueCalculator;
import utils.MatrixValidator;

/**
 * Generates an Ulam spiral matrix using a spoke-based approach. Cells on SW and NW spokes are calculated using predefined formulas.
 * Remaining cells are filled in by incrementing the value of the spoke by appropriate value.
 * <br><br>
 * Seems to follow time complexity of O(n).
 * Faster than the {@link spirals.ulam.generators.SimpleUlamGenerator} approach for all matrix sizes.
 *
 *
 * @see spirals.ulam.calculators.SpokeValueCalculator
 * @author nuclear-bean
 */
public final class SpokeBasedGenerator implements UlamGenerator {

    private final int halfSize;
    private final long[][] matrix;

    public SpokeBasedGenerator(int size) {
        MatrixValidator.validateMatrixSize(size);
        this.halfSize = size / 2;
        this.matrix = new long[size][size];
    }

    public static long[][] generateMatrix(int size) {
        return new SpokeBasedGenerator(size).generate();
    }

    @Override
    public long[][] generate() {
        fillCenter();
        fillTop();
        fillBottom();
        fillLeft();
        fillRight();
        return this.matrix;
    }

    private void fillCenter() {
        matrix[halfSize][halfSize] = 1;
    }

    private void fillBottom() {
        for (int i = matrix.length - 1; i > halfSize; i--) {
            long[] row = matrix[i];
            int startIndex = matrix.length - i - 1;
            row[startIndex] = SpokeValueCalculator.SW(halfSize - startIndex);
            for (int j = startIndex + 1; j < row.length - startIndex; j++) {
                row[j] = row[j - 1] + 1;
            }
        }
    }

    private void fillLeft() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < halfSize; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = matrix[i-1][j] + 1;
                }
            }
        }
    }

    private void fillRight() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = halfSize + 1; j < matrix.length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = matrix[i-1][j] - 1;
                }
            }
        }
    }

    private void fillTop() {
        for (int i = 0; i < halfSize; i++) {
            long[] row = matrix[i];
            row[i] = SpokeValueCalculator.NW(halfSize - i);
            for (int j = i + 1; j < row.length - i; j++) {
                row[j] = row[j - 1] - 1;
            }
        }
    }

}
