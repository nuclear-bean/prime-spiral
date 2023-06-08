package translation;

import lombok.extern.log4j.Log4j2;
import translation.functions.MatrixMappingFunction;

@Log4j2
public class MatrixToMatrixTranslation {

    private final long[][] matrix;
    private final MatrixMappingFunction function;
    private final int matrixSize;
    private final BasicM2MLogger logger;

    int i;
    int j;

    public static long[][] translate(long[][] matrix, MatrixMappingFunction function) {
        log.info("Starting translation");
        long[][] data = new MatrixToMatrixTranslation(matrix, function).doTranslate();
        log.info("Translation finished");
        return data;
    }

    private MatrixToMatrixTranslation(long[][] matrix, MatrixMappingFunction function) {
        this.matrix = matrix;
        this.function = function;
        this.matrixSize = matrix.length;
        this.logger = new BasicM2MLogger(matrixSize, this);
    }

    private long[][] doTranslate() {
        logger.start();
        long[][] mappedMatrixData = new long[matrixSize][matrixSize];
        iterateOverMatrix(mappedMatrixData);
        logger.interrupt();
        return mappedMatrixData;
    }

    private void iterateOverMatrix(long[][] matrix) {
        for (i = 0; i < matrixSize; i++) {
            for (j = 0; j < matrixSize; j++) {
                matrix[i][j] = function.mapPoint(this.matrix, i, j);
            }
        }
    }
}
