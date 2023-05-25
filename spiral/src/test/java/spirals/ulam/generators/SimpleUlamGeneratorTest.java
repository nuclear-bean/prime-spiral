package spirals.ulam.generators;

import org.junit.jupiter.api.Test;

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
    void shouldThrowExceptionWhenSizeIsEven() {
        assertThrows(IllegalArgumentException.class, () -> SimpleUlamGenerator.generateMatrix(4));
    }

    @Test
    void shouldThrowExceptionWhenSizeIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> SimpleUlamGenerator.generateMatrix(-1));
    }
}