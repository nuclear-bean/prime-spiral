package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsolePrinterTest {

    long[][] matrix = new long[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    long[][] bigMatrix = new long[501][501];

    @Test
    void testPrintSimple() {
        ConsolePrinter.printSimple(matrix);
    }

    @Test
    void testPrintSimpleBigMatrix() {
        assertThrows(IllegalArgumentException.class, () -> ConsolePrinter.printSimple(bigMatrix));
    }

}