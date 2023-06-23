package translation.functions;

import export.image.PixelData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Long2PixelDataTest {

    @Test
    void testStatic_BASIC_BLACK_AND_WHITE() {
        Long2PixelData function = Long2PixelData.BASIC_BLACK_AND_WHITE();
        assertPixelDataEquals(PixelData.RED, function.calculatePixelValue(matrixOf(1L), 0, 0));
        assertPixelDataEquals(PixelData.BLACK, function.calculatePixelValue(matrixOf(2L), 0, 0));
        assertPixelDataEquals(PixelData.WHITE, function.calculatePixelValue(matrixOf(4L), 0, 0));
    }

    @Test
    void testStatic_TWIN_PRIMES_BLACK_AND_WHITE() {
        Long2PixelData function = Long2PixelData.TWIN_PRIMES_BLACK_AND_WHITE();
        assertPixelDataEquals(PixelData.BLACK, function.calculatePixelValue(matrixOf(11L), 0, 0));
        assertPixelDataEquals(PixelData.BLACK, function.calculatePixelValue(matrixOf(13L), 0, 0));
        assertPixelDataEquals(PixelData.BLACK, function.calculatePixelValue(matrixOf(17L), 0, 0));
        assertPixelDataEquals(PixelData.BLACK, function.calculatePixelValue(matrixOf(19L), 0, 0));
        assertPixelDataEquals(PixelData.WHITE, function.calculatePixelValue(matrixOf(23L), 0, 0));
        assertPixelDataEquals(PixelData.BLACK, function.calculatePixelValue(matrixOf(29L), 0, 0));
        assertPixelDataEquals(PixelData.BLACK, function.calculatePixelValue(matrixOf(31L), 0, 0));
        assertPixelDataEquals(PixelData.WHITE, function.calculatePixelValue(matrixOf(37L), 0, 0));
    }

    @Test
    void testStatic_SEXY_PRIMES_BLACK_AND_WHITE() {
        Long2PixelData function = Long2PixelData.SEXY_PRIMES_BLACK_AND_WHITE();
        assertPixelDataEquals(PixelData.BLACK, function.calculatePixelValue(matrixOf(5L), 0, 0));
        assertPixelDataEquals(PixelData.BLACK, function.calculatePixelValue(matrixOf(7L), 0, 0));
        assertPixelDataEquals(PixelData.BLACK, function.calculatePixelValue(matrixOf(11L), 0, 0));
        assertPixelDataEquals(PixelData.BLACK, function.calculatePixelValue(matrixOf(13L), 0, 0));
        assertPixelDataEquals(PixelData.BLACK, function.calculatePixelValue(matrixOf(17L), 0, 0));
        assertPixelDataEquals(PixelData.BLACK, function.calculatePixelValue(matrixOf(23L), 0, 0));
        assertPixelDataEquals(PixelData.BLACK, function.calculatePixelValue(matrixOf(29L), 0, 0));
        assertPixelDataEquals(PixelData.BLACK, function.calculatePixelValue(matrixOf(31L), 0, 0));
        assertPixelDataEquals(PixelData.BLACK, function.calculatePixelValue(matrixOf(37L), 0, 0));
        assertPixelDataEquals(PixelData.WHITE, function.calculatePixelValue(matrixOf(1009L), 0, 0));
    }

    @Test
    void testStatic_HIGHLIGHT_TWIN_PRIMES() {
        Long2PixelData function = Long2PixelData.HIGHLIGHT_TWIN_PRIMES();
        assertPixelDataEquals(PixelData.RED, function.calculatePixelValue(matrixOf(11L), 0, 0));
        assertPixelDataEquals(PixelData.RED, function.calculatePixelValue(matrixOf(13L), 0, 0));
        assertPixelDataEquals(PixelData.RED, function.calculatePixelValue(matrixOf(17L), 0, 0));
        assertPixelDataEquals(PixelData.RED, function.calculatePixelValue(matrixOf(19L), 0, 0));
        assertPixelDataEquals(PixelData.WHITE, function.calculatePixelValue(matrixOf(22L), 0, 0));
        assertPixelDataEquals(PixelData.WHITE, function.calculatePixelValue(matrixOf(2002L), 0, 0));
        assertPixelDataEquals(PixelData.BLACK, function.calculatePixelValue(matrixOf(37L), 0, 0));
    }

    @Test
    void testStatic_PRIME_GAP_N_2() {
        Long2PixelData function = Long2PixelData.PRIME_GAP_N(2);
        assertPixelDataEquals(PixelData.BLACK, function.calculatePixelValue(matrixOf(5L), 0, 0));
        assertPixelDataEquals(PixelData.BLACK, function.calculatePixelValue(matrixOf(7L), 0, 0));
        assertPixelDataEquals(PixelData.BLACK, function.calculatePixelValue(matrixOf(11L), 0, 0));
        assertPixelDataEquals(PixelData.BLACK, function.calculatePixelValue(matrixOf(13L), 0, 0));
        assertPixelDataEquals(PixelData.BLACK, function.calculatePixelValue(matrixOf(17L), 0, 0));
        assertPixelDataEquals(PixelData.WHITE, function.calculatePixelValue(matrixOf(23L), 0, 0));
        assertPixelDataEquals(PixelData.BLACK, function.calculatePixelValue(matrixOf(29L), 0, 0));
        assertPixelDataEquals(PixelData.BLACK, function.calculatePixelValue(matrixOf(31L), 0, 0));
        assertPixelDataEquals(PixelData.WHITE, function.calculatePixelValue(matrixOf(37L), 0, 0));
    }

    @Test
    void testStatic_PRIME_GAP_N_4() {
        Long2PixelData function = Long2PixelData.PRIME_GAP_N(4);
        assertPixelDataEquals(PixelData.BLACK, function.calculatePixelValue(matrixOf(7L), 0, 0));
        assertPixelDataEquals(PixelData.BLACK, function.calculatePixelValue(matrixOf(11L), 0, 0));
        assertPixelDataEquals(PixelData.WHITE, function.calculatePixelValue(matrixOf(12L), 0, 0));
        assertPixelDataEquals(PixelData.BLACK, function.calculatePixelValue(matrixOf(13L), 0, 0));
        assertPixelDataEquals(PixelData.BLACK, function.calculatePixelValue(matrixOf(17L), 0, 0));
        assertPixelDataEquals(PixelData.BLACK, function.calculatePixelValue(matrixOf(97L), 0, 0));
    }

    long[][] matrixOf(long value) {
        long [][] matrix = new long[1][1];
        matrix[0][0] = value;
        return matrix;
    }

    void assertPixelDataEquals(PixelData pd1, PixelData pd2) {
        assertEquals(pd1.getRed(), pd2.getRed());
        assertEquals(pd1.getGreen(), pd2.getGreen());
        assertEquals(pd1.getBlue(), pd2.getBlue());
    }

}