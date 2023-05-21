package spirals.ulam.translators.density;

import lombok.experimental.UtilityClass;

/**
 * Accepts binary matrix and translates it to density matrix. Density is calculated as sum of all 8 neighbours and self. Each prime neighbour is counted as 1, each non-prime as 0.
 */
@UtilityClass
public class DensityTranslator {

    public short[][] translate(boolean[][] matrix) {
        short[][] densityMatrix = new short[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < densityMatrix[i].length; j++) {
                densityMatrix[i][j] = calculateDensity(matrix, i, j);
            }
        }
        return densityMatrix;
    }

    private static short calculateDensity(boolean[][] matrix, int i, int j) {
        short density = 0;

        density += getDensity(matrix, i - 1, j - 1); // top left
        density += getDensity(matrix, i - 1, j); // top
        density += getDensity(matrix, i - 1, j + 1); // top right
        density += getDensity(matrix, i, j - 1); // left
        density += getDensity(matrix, i, j); // self
        density += getDensity(matrix, i, j + 1); // right
        density += getDensity(matrix, i + 1, j - 1); // bottom left
        density += getDensity(matrix, i + 1, j); // bottom
        density += getDensity(matrix, i + 1, j + 1); // bottom right

        return density;
    }

    private static int getDensity(boolean[][] matrix, int i, int j) {
        try {
            return matrix[i][j] ? 1 : 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 0;
        }
    }
}
