package spiral.core.generator;

import lombok.experimental.UtilityClass;
import spiral.core.Matrix;
import spiral.core.utils.Validator;
import spiral.experimental.MatrixFiller;

@UtilityClass
public class BasicGenerator {

    public Matrix createUlamSpiral(int side) {
        Validator.validateMatrixSize(side);
        Matrix matrix = new Matrix(side);
        long[][] content = new long[side][side];
        MatrixFiller.ulamSpiralCounterClockwise(content);
        matrix.fillWith(content);
        return matrix;
    }
}
