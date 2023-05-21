package spirals.ulam.translators;

import org.junit.jupiter.api.Test;
import spirals.ulam.generators.SimpleUlamGenerator;
import utils.ConsolePrinter;

import static org.junit.jupiter.api.Assertions.*;

class DensityTranslatorTest {

    @Test
    public void testDensityTranslation_1() {
        long [][] input = SimpleUlamGenerator.generateMatrix(3);
        boolean[][] booleans = BinaryTranslator.translateToBoolean(input);
        short [][] expected = {{1, 3, 2}, {2, 4, 2}, {1, 2, 1}};
        short [][] actual = DensityTranslator.translate(booleans);
        ConsolePrinter.prettyPrintMatrixWithFrames(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDensityTranslation_2() {
        long [][] input = SimpleUlamGenerator.generateMatrix(5);
        boolean[][] booleans = BinaryTranslator.translateToBoolean(input);
        short [][] expected = {{2, 2, 2, 2, 2}, {3, 3, 3, 4, 4}, {3, 3, 4, 3, 3}, {2, 3, 3, 3, 2}, {1, 2, 2, 1, 0}};
        short [][] actual = DensityTranslator.translate(booleans);
        ConsolePrinter.prettyPrintMatrixWithFrames(input);
        assertArrayEquals(expected, actual);
    }

}