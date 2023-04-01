package spiral.core.generator;

import lombok.experimental.UtilityClass;
import spiral.core.Matrix;
import spiral.experimental.MatrixFiller;

@UtilityClass
public class BasicGenerator {

    public Matrix createUlamSpiral(int side) {
        validateSide(side);
        Matrix matrix = new Matrix(side);
        long[][] content = new long[side][side];
        MatrixFiller.ulamSpiralCounterClockwise(content);
        matrix.fillWith(content);
        return matrix;
    }

    private void validateSide(int side) {
        if (side%2 == 0) throw new IllegalArgumentException("Only odd number spirals are allowed.");
    }
}
