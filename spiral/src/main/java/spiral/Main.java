package spiral;

public class Main {

    private static final int SIZE = 3001;

    public static void main(String[] args) {
        Matrix matrix = MatrixGenerator.createUlamSpiral(SIZE);
        matrix.print();
//        Printer.prettyPrintMatrixWithFrames(matrix.getContent());
    }

}
