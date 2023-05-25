package spirals.ulam.translators.density;

import lombok.experimental.UtilityClass;

/**
 * Accepts binary matrix and translates it to density matrix. Density is calculated as sum of all 8 neighbours and self. Each prime neighbour is counted as 1, each non-prime as 0.
 */
@UtilityClass
public class CustomizableDensityTranslator {

    public short[][] translate(DensityTranslationSpec spec) {
        short[][] densityMatrix = new short[spec.getMatrix().length][spec.getMatrix().length];
        for (int i = 0; i < spec.getMatrix().length; i++) {
            for (int j = 0; j < densityMatrix[i].length; j++) {
                densityMatrix[i][j] = calculateDensity(spec, i, j);
            }
        }
        return densityMatrix;
    }

    private static short calculateDensity(DensityTranslationSpec spec, int i, int j) {
        short density = 0;

        boolean[][] matrix = spec.getMatrix();

        if (spec.isTopLeft()) {
            density += getDensity(matrix, i - 1, j - 1); // top left
        }
        if (spec.isTop()) {
            density += getDensity(matrix, i - 1, j); // top
        }
        if (spec.isTopRight()) {
            density += getDensity(matrix, i - 1, j + 1); // top right
        }
        if (spec.isLeft()) {
            density += getDensity(matrix, i, j - 1); // left
        }
        if (spec.isSelf()) {
            density += getDensity(matrix, i, j); // self
        }
        if (spec.isRight()) {
            density += getDensity(matrix, i, j + 1); // right
        }
        if (spec.isBottomLeft()) {
            density += getDensity(matrix, i + 1, j - 1); // bottom left
        }
        if (spec.isBottom()) {
            density += getDensity(matrix, i + 1, j); // bottom
        }
        if (spec.isBottomRight()) {
            density += getDensity(matrix, i + 1, j + 1); // bottom right
        }
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
