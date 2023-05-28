package utils.matrix;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public final class MatrixMapper {

    public static long[][] shorts2longs(short[][] matrix) {
        long[][] longMatrix = new long[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < longMatrix[i].length; j++) {
                longMatrix[i][j] = matrix[i][j];
            }
        }
        return longMatrix;
    }

}
