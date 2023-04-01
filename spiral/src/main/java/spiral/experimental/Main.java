package spiral.experimental;

import spiral.core.Matrix;
import spiral.core.generator.BasicGenerator;
import spiral.core.utils.annotations.Experimental;

@Experimental
public class Main {

    private static final int SIZE = 3;

    public static void main(String[] args) {
        Matrix matrix = BasicGenerator.createUlamSpiral(SIZE);
        matrix.print();
    }

}
