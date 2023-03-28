package spiral;

public class Main {

    private static final int SIZE = 5;
    private static Matrix matrix;

    public static void main(String[] args) {
        initMatrix();
        fillMatrix();

        // calc center

        printMatrix(matrix);
    }

    private static void fillMatrix() {
        int cnt = 2;
        for (int i = 0; i < matrix.content.length; i++) {
            for (int j = 0; j < matrix.content[i].length; j++) {
                Point p = matrix.content[i][j];
                if (p == null) {
                    matrix.content[i][j] = new Point();
                    matrix.content[i][j].value = cnt++;
                }
            }
        }
    }

    private static void printMatrix(Matrix matrix) {
        for (int i = 0; i < matrix.size; i++) {
            for (int j = 0; j < matrix.size; j++) {
                Integer val = matrix.content[i][j].value;
                if (val == null) val = -1;
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    private static void initMatrix() {
        matrix = new Matrix(SIZE);
    }
}
