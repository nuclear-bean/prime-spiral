package spirals.ulam.translators;

import lombok.experimental.UtilityClass;
import math.PrimeUtils;

@UtilityClass
public class BinaryTranslator {

    public long[][] translate(long[][] matrix) {
        long[][] binaryMatrix = new long[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < binaryMatrix[i].length; j++) {
                if (PrimeUtils.isPrime(matrix[i][j])) {
                    binaryMatrix[i][j] = 1;
                } else {
                    binaryMatrix[i][j] = 0;
                }
            }
        }
        return binaryMatrix;
    }
}
