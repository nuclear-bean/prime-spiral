package spiral.experimental;

import spiral.core.matrix.Matrix;
import spiral.core.utils.annotations.Experimental;

@Experimental
public class ExperimentalMatrix extends Matrix {

    public ExperimentalMatrix(int size) {
        super(size);
    }

    public long getPoint(int x, int y) {
        return content[(size/2) + x][(size/2) + y];
    }


    public short[][] translate() {
        throw new UnsupportedOperationException();
    }


}
