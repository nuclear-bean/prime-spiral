package matrix.operations;

import static matrix.MatrixUtils.safeIsTrue;

class DiagonalOperations {


    static int diagonalCountOfTrueCellsWithinRadius(boolean[][] matrix, int i, int j, int radius) {
        if (radius == 0) {
            return 0;
        }
        int count = 0;
        count += topLeft(matrix, i, j, radius);
        count += topRight(matrix, i, j, radius);
        count += bottomLeft(matrix, i, j, radius);
        count += bottomRight(matrix, i, j, radius);
        return count;
    }

    private static int topRight(boolean[][] matrix, int i, int j, int radius) {
        int count = 0;
        for (int i1 = 1; i1 <= radius; i1++) {
            if (safeIsTrue(matrix, i - i1, j + i1)) {
                count++;
            }
        }
        return count;
    }

    private static int bottomLeft(boolean[][] matrix, int i, int j, int radius) {
        int count = 0;
        for (int i1 = 1; i1 <= radius; i1++) {
            if (safeIsTrue(matrix, i + i1, j - i1)) {
                count++;
            }
        }
        return count;
    }

    private static int bottomRight(boolean[][] matrix, int i, int j, int radius) {
        int count = 0;
        for (int i1 = 1; i1 <= radius; i1++) {
            if (safeIsTrue(matrix, i + i1, j + i1)) {
                count++;
            }
        }
        return count;
    }

    private static int topLeft(boolean[][] matrix, int i, int j, int radius) {
        int count = 0;
        for (int i1 = 1; i1 <= radius; i1++) {
            if (safeIsTrue(matrix, i - i1, j - i1)) {
                count++;
            }
        }
        return count;
    }
}
