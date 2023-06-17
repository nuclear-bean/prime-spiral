package experimental;

import spirals.ulam.generators.SimpleUlamGenerator;
import utils.ConsolePrinter;

public class ExperimentalGenerator {

    public static void main(String[] args) {
        ConsolePrinter.printSimple(SimpleUlamGenerator.generateMatrix(7));
        System.out.println("-");
        long[][] matrix = generate(7);
        ConsolePrinter.printSimple(matrix);
    }

    public static long[][] generate(int i) {
        long [][] matrix = new long[i][i];
        fillTop(matrix);
        fillBottom(matrix);
        fillLeft(matrix);
        fillRight(matrix);
        fillCenter(matrix);
        return matrix;
    }

    private static void fillCenter(long[][] matrix) {
        ExperimentalMatrixUtils.Coordinates c = ExperimentalMatrixUtils.getCenterCoordinates(matrix);
        matrix[c.i][c.j] = 1;
    }

    private static void fillBottom(long[][] matrix) {
        int halfSize = matrix.length / 2;
        for (int i = matrix.length - 1; i > halfSize; i--) {
            long[] row = matrix[i];
            int startIndex = matrix.length - i - 1;
            row[startIndex] = SW(halfSize - startIndex);
            for (int j = startIndex + 1; j < row.length - startIndex; j++) {
                row[j] = row[j - 1] + 1;
            }
        }
    }

    private static void fillLeft(long[][] matrix) {
        int halfSize = matrix.length / 2;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < halfSize; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = matrix[i-1][j] + 1;
                }
            }
        }
    }

    private static void fillRight(long[][] matrix) {
        int halfSize = matrix.length / 2;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = halfSize + 1; j < matrix.length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = matrix[i-1][j] - 1;
                }
            }
        }
    }

    private static void fillTop(long[][] matrix) {
        int halfSize = matrix.length / 2;
        for (int i = 0; i < halfSize; i++) {
            long[] row = matrix[i];
            row[i] = NW(halfSize - i);
            for (int j = i + 1; j < row.length - i; j++) {
                row[j] = row[j - 1] - 1;
            }
        }
    }

    public static long NW(int n) {
        long inside = (n * 2L) + 1L;
        long insideSquared = inside * inside;
        return insideSquared - (4L*n);
    }

    public static long SE(int n) {
        long inside = (n * 2L) + 1L;
        return inside * inside;
    }

    public static long SW(int n) {
        long inside = (n * 2L) + 1L;
        long insideSquared = inside * inside;
        return insideSquared - (2L*n);
    }


}
