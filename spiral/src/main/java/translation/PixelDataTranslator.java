package translation;

import translation.functions.TranslationFunction;
import visualtization.PixelData;

class PixelDataTranslator {

    private final long[][] matrix;
    private final TranslationFunction function;
    private final int matrixSize;

    int i;
    int j;

    PixelDataTranslator(long[][] matrix, TranslationFunction function) {
        this.matrix = matrix;
        this.function = function;
        this.matrixSize = matrix.length;
    }

    PixelData[][] doTranslate() {
        PixelData[][] outputImageData = new PixelData[matrixSize][matrixSize];
        for (i = 0; i < matrixSize; i++) {
            for (j = 0; j < matrixSize; j++) {
                outputImageData[i][j] = function.calculatePixelValue(matrix, i, j);
            }
        }
        return outputImageData;
    }
}
