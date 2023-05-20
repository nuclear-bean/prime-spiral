package spiral.core.generator;

import lombok.experimental.UtilityClass;
import spiral.core.matrix.Matrix;
import spiral.core.utils.Validator;
import spiral.core.matrix.filler.SimpleMatrixFiller;

@UtilityClass
public class BasicGenerator {

    public Matrix createUlamSpiral(int side) {
        Validator.validateMatrixSize(side);
        Matrix matrix = new Matrix(side);
        long[][] content = new long[side][side];
        SimpleMatrixFiller.ulamSpiralCounterClockwise(content);
        matrix.fillWith(content);
        return matrix;
    }
}
