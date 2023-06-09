package matrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixUtilsTest {

    @Test
    public void testSafeIsTrue_withinBoundsFalse() {
        boolean[][] matrix = {
                {true, false, true},
                {false, true, false},
                {true, true, false}
        };

        boolean result = MatrixUtils.safeIsTrue(matrix, 1, 2);

        Assertions.assertFalse(result);
    }

    @Test
    public void testSafeIsTrue_withinBoundsTrue() {
        boolean[][] matrix = {
                {true, false, true},
                {false, true, false},
                {true, true, false}
        };

        boolean result = MatrixUtils.safeIsTrue(matrix, 0, 0);

        Assertions.assertTrue(result);
    }

    @Test
    public void testSafeIsTrue_outOfBounds() {
        boolean[][] matrix = {
                {true, false},
                {false, true}
        };

        boolean result = MatrixUtils.safeIsTrue(matrix, 2, 1);

        Assertions.assertFalse(result);
    }

    @Test
    public void testSafeIsTrue_emptyMatrix() {
        boolean[][] matrix = {};

        boolean result = MatrixUtils.safeIsTrue(matrix, 0, 0);

        Assertions.assertFalse(result);
    }

    @Test
    public void testSafeIsTrue_onBorder() {
        boolean[][] matrix = {
                {true, false, true},
                {false, true, false},
                {true, true, false}
        };

        boolean result = MatrixUtils.safeIsTrue(matrix, 0, 1);

        Assertions.assertFalse(result);
    }

    @SuppressWarnings({"ConstantConditions", "ResultOfMethodCallIgnored"})
    @Test
    public void testSafeIsTrue_nullMatrix() {
        boolean[][] matrix = null;

        Assertions.assertThrows(NullPointerException.class, () -> MatrixUtils.safeIsTrue(matrix, 0, 0));
    }
}
