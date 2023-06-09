package translation;

import lombok.extern.log4j.Log4j2;
import translation.functions.Boolean2LongFunction;
import translation.functions.Long2BooleanFunction;
import translation.functions.Long2PixelData;
import visualtization.PixelData;

/**
 * Utility class for translating matrices with given translation function
 */
@Log4j2
public final class MatrixTranslator {

    public static PixelData[][] translate(long[][] matrix, Long2PixelData function) {
        log.info("Starting translation");
        int matrixSize = matrix.length;
        PixelData[][] results = new PixelData[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                results[i][j] = function.calculatePixelValue(matrix, i, j);
            }
        }
        log.info("Translation finished");
        return results;
    }

    public static boolean[][] translate(long [][] matrix, Long2BooleanFunction function) {
        log.info("Starting translation");
        int matrixSize = matrix.length;
        boolean[][] results = new boolean[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                results[i][j] = function.apply(matrix[i][j]);
            }
        }
        log.info("Translation finished");
        return results;
    }

    public static long[][] translate(boolean [][] matrix, Boolean2LongFunction function) {
        log.info("Starting translation");
        int matrixSize = matrix.length;
        long[][] results = new long[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                results[i][j] = function.apply(matrix, i, j);
            }
        }
        log.info("Translation finished");
        return results;
    }


}
