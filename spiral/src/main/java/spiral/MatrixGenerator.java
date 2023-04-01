package spiral;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MatrixGenerator {

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
