package translation;

import math.PrimeUtils;
import org.junit.jupiter.api.Test;
import translation.functions.Long2PixelData;
import export.PixelData;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTranslatorTest {

    @Test
    void testTranslateLong2PixelData() {
        long[][] input = new long[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        Long2PixelData translationFunction = (matrix, i, j) -> new PixelData((int) matrix[i][j], (int) matrix[i][j], (int) matrix[i][j]);
        PixelData[][] actual = MatrixTranslator.translate(input, translationFunction);
        for (int i = 0; i < actual.length; i++) {
            for (int j = 0; j < actual[i].length; j++) {
                assertEquals(actual[i][j].getRed(), input[i][j]);
                assertEquals(actual[i][j].getGreen(), input[i][j]);
                assertEquals(actual[i][j].getBlue(), input[i][j]);
            }
        }
    }

    @Test
    void testTranslateLong2BooleanFunction() {
        long[][] input = new long[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        boolean[][] expected = new boolean[][]{
                {false, true, true},
                {false, true, false},
                {true, false, false}};
        boolean[][] actual = MatrixTranslator.translate(input, PrimeUtils::isPrime);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testTranslateBoolean2LongFunction() {
        boolean[][] input = new boolean[][]{
                {false, true, true},
                {false, true, false},
                {true, false, false}};
        long[][] expected = new long[][]{
                {0, 1, 1},
                {0, 1, 0},
                {1, 0, 0}};
        long[][] actual = MatrixTranslator.translate(input, (matrix, i, j) -> matrix[i][j] ? 1 : 0);
        assertArrayEquals(expected, actual);
    }
}