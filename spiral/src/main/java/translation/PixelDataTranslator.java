package translation;

import lombok.extern.log4j.Log4j2;
import translation.functions.Boolean2PixelDataFunction;
import translation.functions.Long2PixelData;
import visualtization.PixelData;

@Log4j2
public class PixelDataTranslator {

    private final long[][] matrix;
    private final Long2PixelData function;
    private final int matrixSize;
    private final BasicPDTLogger logger;

    int i;
    int j;

    public static PixelData[][] translate(boolean[][] matrix, Boolean2PixelDataFunction function) {
        log.info("Starting translation");
        int matrixSize = matrix.length;
        PixelData[][] results = new PixelData[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                results[i][j] = function.apply(matrix, i, j);
            }
        }
        log.info("Translation finished");
        return results;
    }

    public static PixelData[][] translate(long[][] matrix, Long2PixelData function) {
        log.info("Starting translation");
        PixelData[][] data = new PixelDataTranslator(matrix, function).doTranslate();
        log.info("Translation finished");
        return data;
    }

    private PixelDataTranslator(long[][] matrix, Long2PixelData function) {
        this.matrix = matrix;
        this.function = function;
        this.matrixSize = matrix.length;
        this.logger = new BasicPDTLogger(matrixSize, this);
    }

    private PixelData[][] doTranslate() {
        logger.start();
        PixelData[][] outputImageData = new PixelData[matrixSize][matrixSize];
        iterateOverMatrix(outputImageData);
        logger.interrupt();
        return outputImageData;
    }

    private void iterateOverMatrix(PixelData[][] outputImageData) {
        for (i = 0; i < matrixSize; i++) {
            for (j = 0; j < matrixSize; j++) {
                outputImageData[i][j] = function.calculatePixelValue(matrix, i, j);
            }
        }
    }
}
