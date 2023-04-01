package spiral.experimental;

import spiral.core.Matrix;
import spiral.core.generator.BasicGenerator;

public class Main {

    private static final int SIZE = 3001;

    public static void main(String[] args) {
        Matrix matrix = BasicGenerator.createUlamSpiral(SIZE);
        matrix.print();
//        Printer.prettyPrintMatrixWithFrames(matrix.getContent());
    }

}
