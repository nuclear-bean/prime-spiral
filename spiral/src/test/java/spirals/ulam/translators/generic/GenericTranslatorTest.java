package spirals.ulam.translators.generic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericTranslatorTest {

    @Test
    void testTranslate() {
        boolean[][] matrix = {
                {true, false, true},
                {false, true, false},
                {true, false, true}
        };

        MatrixMappingFunction function = (i, j, boolMatrix) -> boolMatrix[i][j] ? (short)1 : (short)0;

        short[][] result = GenericTranslator.translate(matrix, function);

        short[][] expected = {
                {1, 0, 1},
                {0, 1, 0},
                {1, 0, 1}
        };

        assertArrayEquals(expected, result);
    }

}