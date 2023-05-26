package utils.matrix.operations;

import lombok.experimental.UtilityClass;

import static utils.matrix.MatrixUtils.safeIsTrue;

@UtilityClass 
class AxialOperations {

    static int get_axial_count_of_true_cells_within_radius(boolean[][] matrix, int i, int j, int radius) {
        if (radius == 0) {
            return 0;
        }

        int total = 0;
        total += top(matrix, i, j, radius);
        total += bottom(matrix, i, j, radius);
        total += left(matrix, i, j, radius);
        total += right(matrix, i, j, radius);
        return total;
    }

    private static int top(boolean[][] matrix, int i, int j, int radius) {
        int total = 0;
        for (int i1 = 1; i1 <= radius; i1++) {
            if (safeIsTrue(matrix, i - i1, j)) {
                total++;
            }
        }
        return total;
    }

    private static int bottom(boolean[][] matrix, int i, int j, int radius) {
        int total = 0;
        for (int i1 = 1; i1 <= radius; i1++) {
            if (safeIsTrue(matrix, i + i1, j)) {
                total++;
            }
        }
        return total;
    }

    private static int left(boolean[][] matrix, int i, int j, int radius) {
        int total = 0;
        for (int j1 = 1; j1 <= radius; j1++) {
            if (safeIsTrue(matrix, i, j - j1)) {
                total++;
            }
        }
        return total;
    }

    private static int right(boolean[][] matrix, int i, int j, int radius) {
        int total = 0;
        for (int j1 = 1; j1 <= radius; j1++) {
            if (safeIsTrue(matrix, i, j + j1)) {
                total++;
            }
        }
        return total;
    }

}
