package translation;

import lombok.extern.log4j.Log4j2;
import translation.functions.BooleanToLongFunction;

@Log4j2
public class Boolean2LongTranslator {

    public static long[][] translate(boolean [][] matrix, BooleanToLongFunction function) {
       log.info("Starting translation");
        long [][] results = calculate(matrix, function);
       log.info("Translation finished");
       return results;
    }

    private static long[][] calculate(boolean[][] matrix, BooleanToLongFunction function) {
        int matrixSize = matrix.length;
        long[][] results = new long[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
               results[i][j] = function.apply(matrix, i, j);
            }
        }
        return results;
    }
}
