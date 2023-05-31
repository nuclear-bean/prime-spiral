package spirals.ulam.generators;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import utils.ConsolePrinter;

import static org.junit.jupiter.api.Assertions.*;

class SimpleUlamGeneratorTest {

    @Test
    void shouldProperlyFillMatrix() {
        long[][] expected = {
                {17, 16, 15, 14, 13},
                {18, 5, 4, 3, 12},
                {19, 6, 1, 2, 11},
                {20, 7, 8, 9, 10},
                {21, 22, 23, 24, 25}
        };
        long[][] actual = SimpleUlamGenerator.generateMatrix(5);
        assertArrayEquals(expected, actual);
    }

    @Test
    void checkSpecificPoints() {
        long[][] matrix = SimpleUlamGenerator.generateMatrix(5);
        assertEquals(1, matrix[2][2]);
        assertEquals(2, matrix[2][3]);
        assertEquals(3, matrix[1][3]);
        assertEquals(4, matrix[1][2]);
        assertEquals(5, matrix[1][1]);
        assertEquals(6, matrix[2][1]);
        assertEquals(7, matrix[3][1]);
        assertEquals(8, matrix[3][2]);
        assertEquals(9, matrix[3][3]);
        assertEquals(10, matrix[3][4]);
        assertEquals(11, matrix[2][4]);
        assertEquals(12, matrix[1][4]);
        assertEquals(13, matrix[0][4]);
        assertEquals(14, matrix[0][3]);
        assertEquals(15, matrix[0][2]);
        assertEquals(16, matrix[0][1]);
        assertEquals(17, matrix[0][0]);
        assertEquals(18, matrix[1][0]);
        assertEquals(19, matrix[2][0]);
        assertEquals(20, matrix[3][0]);
        assertEquals(21, matrix[4][0]);
        assertEquals(22, matrix[4][1]);
        assertEquals(23, matrix[4][2]);
        assertEquals(24, matrix[4][3]);
        assertEquals(25, matrix[4][4]);
    }

    @Test
    void shouldThrowExceptionWhenSizeIsEven() {
        assertThrows(IllegalArgumentException.class, () -> SimpleUlamGenerator.generateMatrix(4));
    }

    @Test
    void shouldThrowExceptionWhenSizeIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> SimpleUlamGenerator.generateMatrix(-1));
    }

    @Test
    @Disabled("Manual")
    void printMatrix() {
        ConsolePrinter.printSimple(SimpleUlamGenerator.generateMatrix(5));
    }
}