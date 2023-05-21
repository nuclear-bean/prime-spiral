package spiral.core.generator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicGeneratorTest {

    @Test
    public void testGeneration() {
        long[][] matrix = BasicGenerator.generateUlamSpiral(5).getContent();
        long[][] expected = {
                {17, 16, 15, 14, 13},
                {18, 5, 4, 3, 12},
                {19, 6, 1, 2, 11},
                {20, 7, 8, 9, 10},
                {21, 22, 23, 24, 25}
        };
        assertArrayEquals(expected, matrix);
    }
}