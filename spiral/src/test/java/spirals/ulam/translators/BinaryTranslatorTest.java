package spirals.ulam.translators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTranslatorTest {

    @Test
    public void testTranslation_1() {
        long [][] input = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        long [][] expected = {{0, 1, 1}, {0, 1, 0}, {1, 0, 0}};
        long [][] actual = BinaryTranslator.translate(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testTranslation_2() {
        long [][] input = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10 ,11, 12}, {13, 14, 15, 16}};
        long [][] expected = {{0, 1, 1, 0}, {1, 0, 1, 0}, {0, 0, 1, 0}, {1, 0, 0, 0}};
        long [][] actual = BinaryTranslator.translate(input);
        assertArrayEquals(expected, actual);
    }

}