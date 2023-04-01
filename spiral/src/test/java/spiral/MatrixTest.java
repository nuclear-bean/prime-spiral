package spiral;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MatrixTest {

    static Matrix matrix;

    @BeforeEach
    void initializeMatrix() {
        int size = 101;
        matrix = new Matrix(size);
        long[][] content = new long[size][size];
        MatrixFiller.ulamSpiralCounterClockwise(content);
        matrix.fillWith(content);
    }

    //todo moveme
    private long[][] mapContent(long[][] input) {
        long[][] output = new long[input.length][input.length];
        for (int i = 0; i < output.length; i++) {
            System.arraycopy(input[i], 0, output[i], 0, output[i].length);
        }
        return output;
    }


}