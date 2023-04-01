package spiral.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixTest {

    @Test
    public void testFillWith3x3() {
        Matrix matrix = new Matrix(3);
        long[][] input = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        matrix.fillWith(input);
        Assertions.assertArrayEquals(input, matrix.getContent());
    }

    @Test
    public void testFillWith5x5() {
        Matrix matrix = new Matrix(5);
        long[][] input = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        matrix.fillWith(input);
        Assertions.assertArrayEquals(input, matrix.getContent());
    }

}

