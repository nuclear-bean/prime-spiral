package spiral;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spiral.core.utils.Validator;

public class ValidatorTest {


    @Test
    @DisplayName("Valid matrix size")
    void testValidateMatrixSize_validSize() {
        Assertions.assertDoesNotThrow(() -> Validator.validateMatrixSize(5));
    }

    @Test
    @DisplayName("Too small matrix size")
    void testValidateMatrixSize_tooSmallSize() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Validator.validateMatrixSize(2),
                "Spiral size should be at least 3");
    }

    @Test
    @DisplayName("Even matrix size")
    void testValidateMatrixSize_evenSize() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Validator.validateMatrixSize(4),
                "Only odd spirals are allowed");
    }

    @Test
    @DisplayName("Odd matrix size")
    void testValidateMatrixSize_oddSize() {
        Assertions.assertDoesNotThrow(() -> Validator.validateMatrixSize(7));
    }
}