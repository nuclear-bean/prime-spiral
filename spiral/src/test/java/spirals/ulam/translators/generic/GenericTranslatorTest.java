package spirals.ulam.translators.generic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericTranslatorTest {

    @Test
    void testTranslate() {
        Boolean[][] matrix = {
                {true, false, true},
                {false, true, false},
                {true, false, true}
        };

        MatrixElementMappingFunction function = (i, j, boolMatrix) -> boolMatrix[i][j] ? (short)1 : (short)0;

        GenericTranslator translator = new GenericTranslator();
        Short[][] result = translator.translate(matrix, function);

        Short[][] expected = {
                {1, 0, 1},
                {0, 1, 0},
                {1, 0, 1}
        };

        assertArrayEquals(expected, result);
    }

}