package experimental;

import lombok.extern.log4j.Log4j2;
import spirals.ulam.utils.SpokeValueCalculator;

import java.time.Instant;

@Log4j2
public class ExperimentalGenerator {

    public static void main(String[] args) {
        int size = 50_000;

        log.info("Starting experimental generator");
        Instant experimentalGeneratorStart = Instant.now();
        long [][] matrix = ExperimentalGenerator.generate(size);
        Instant experimentalGeneratorEnd = Instant.now();

        long experimentalGeneratorDuration = experimentalGeneratorEnd.toEpochMilli() - experimentalGeneratorStart.toEpochMilli();

        System.out.println("Experimental generator duration: " + experimentalGeneratorDuration + " ms for size: " + size);

        long maxValue = matrix[0][0];
        System.out.println("Max value: " + maxValue);
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
            row[startIndex] = SpokeValueCalculator.SW(halfSize - startIndex);
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
            row[i] = SpokeValueCalculator.NW(halfSize - i);
            for (int j = i + 1; j < row.length - i; j++) {
                row[j] = row[j - 1] - 1;
            }
        }
    }


}
