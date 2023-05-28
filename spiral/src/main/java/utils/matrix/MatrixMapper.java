package utils.matrix;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public final class MatrixMapper {

    /**
     * @return long matrix. Simple type conversion.
     */
    public static long[][] shorts2longs(short[][] matrix) {
        long[][] longMatrix = new long[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < longMatrix[i].length; j++) {
                longMatrix[i][j] = matrix[i][j];
            }
        }
        return longMatrix;
    }

    /**
     * @return boolean matrix. 1s are mapped to true, 0s to false.
     * @throws IllegalArgumentException if matrix contains anything but 1s and 0s
     */
    public static boolean[][] mapToBoolean(short[][] matrix) {
        boolean[][] binaryMatrix = new boolean[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < binaryMatrix[i].length; j++) {
                binaryMatrix[i][j] = switch (matrix[i][j]) {
                    case 1 -> binaryMatrix[i][j] = true;
                    case 0 -> binaryMatrix[i][j] = false;
                    default -> throw new IllegalArgumentException("Only 1s and 0s are allowed");
                };
            }
        }
        return binaryMatrix;
    }

}
