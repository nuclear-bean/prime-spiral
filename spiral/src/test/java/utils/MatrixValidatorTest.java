package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixValidatorTest {

    @Test
    void testMatrixTooSmall() {
        assertThrows(IllegalArgumentException.class, () -> MatrixValidator.validateMatrixSize(1));
    }

    @Test
    void testMatrixEven() {
        assertThrows(IllegalArgumentException.class, () -> MatrixValidator.validateMatrixSize(8));
    }

    @Test
    void testMatrixOdd() {
        assertDoesNotThrow(() -> MatrixValidator.validateMatrixSize(9));
    }

}