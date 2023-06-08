package translation;

import lombok.extern.log4j.Log4j2;
import translation.functions.Long2BooleanFunction;

@Log4j2
public class Long2BooleanTranslator {

    public static boolean[][] translate(long [][] matrix, Long2BooleanFunction function) {
       log.info("Starting translation");
       boolean [][] results = calculate(matrix, function);
       log.info("Translation finished");
       return results;
    }

    private static boolean[][] calculate(long[][] matrix, Long2BooleanFunction function) {
        int matrixSize = matrix.length;
        boolean[][] results = new boolean[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
               results[i][j] = function.apply(matrix[i][j]);
            }
        }
        return results;
    }
}
