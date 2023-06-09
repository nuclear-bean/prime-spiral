package translation;

import lombok.extern.log4j.Log4j2;
import translation.functions.Boolean2LongFunction;
import translation.functions.Long2BooleanFunction;
import translation.functions.Long2PixelData;
import visualtization.PixelData;

import java.time.Instant;

/**
 * Utility class for translating matrices with given translation function
 */
@Log4j2
public final class MatrixTranslator {

    private static Instant lastLog = Instant.now();

    public static PixelData[][] translate(long[][] matrix, Long2PixelData function) {
        int matrixSize = matrix.length;
        PixelData[][] results = new PixelData[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                results[i][j] = function.calculatePixelValue(matrix, i, j);
                logProgress(i, j, matrixSize);
            }
        }
        return results;
    }

    public static boolean[][] translate(long [][] matrix, Long2BooleanFunction function) {
        int matrixSize = matrix.length;
        boolean[][] results = new boolean[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                results[i][j] = function.apply(matrix[i][j]);
                logProgress(i, j, matrixSize);
            }
        }
        return results;
    }

    public static long[][] translate(boolean [][] matrix, Boolean2LongFunction function) {
        int matrixSize = matrix.length;
        long[][] results = new long[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                results[i][j] = function.apply(matrix, i, j);
                logProgress(i, j, matrixSize);
            }
        }
        return results;
    }

    private static void logProgress(int i, int j, int matrixSize) {
        if (lastLog.plusSeconds(1).isBefore(Instant.now())) {
            int processed = i * matrixSize + j;
            int matrixElementsCount = matrixSize * matrixSize;
            double progress = (double) processed / matrixElementsCount * 100;
            log.info(String.format("Progress: %.2f%%", progress));
            lastLog = Instant.now();
        }
    }

}
