package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to retrieve matrix elements within a given radius from a specified point.
 */
public class MatrixElementsWithinRadiusUtils {

    /**
     * Returns a list of elements within a given radius from a specified point.
     *
     * @param matrix matrix to retrieve elements from
     * @param i      row index of the specified point
     * @param j      column index of the specified point
     * @param radius radius from the specified point
     * @return list of elements within a given radius from a specified point
     */
    public static List<Integer> getElementsWithinRadius(int[][] matrix, int i, int j, int radius) {
        List<Integer> result = new ArrayList<>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int distance = calculateDistance(i, j, row, col);
                if (distance <= radius) {
                    result.add(matrix[row][col]);
                }
            }
        }

        return result;
    }

    /**
     * Returns number of true cells within a given radius from a specified point.
     *
     * @param matrix boolean matrix to retrieve elements from
     * @param i      row index of the specified point
     * @param j      column index of the specified point
     * @param radius radius from the specified point
     * @return number of true cells within a given radius from a specified point
     */
    public static int getCountOfTrueCellsWithinRadius(boolean[][] matrix, int i, int j, int radius) {
        int count = 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int row = 0; row < rows; row++) {
            if (row < i - radius || row > i + radius) {
                continue;
            }
            for (int col = 0; col < cols; col++) {
                int distance = calculateDistance(i, j, row, col);
                if (distance <= radius && matrix[row][col]) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int getCountOfTrueCellsOnDiagonalsWithinRadius(boolean[][] matrix, int i, int j, int radius) {
        if (radius == 0) {
            return 0;
        }

        int count = 0;

        // top left
        for (int i1 = 1; i1 <= radius; i1++) {
            try {
                if (matrix[i - i1][j - i1]) {
                    count++;
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {}
        }

        // top right
        for (int i1 = 1; i1 <= radius; i1++) {
            try {
                if (matrix[i - i1][j + i1]) {
                    count++;
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {}
        }

        // bottom left
        for (int i1 = 1; i1 <= radius; i1++) {
            try {
                if (matrix[i + i1][j - i1]) {
                    count++;
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {}
        }

        // bottom right
        for (int i1 = 1; i1 <= radius; i1++) {
            try {
                if (matrix[i + i1][j + i1]) {
                    count++;
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {}
        }

        return count;
    }

    public static int getCountOfTrueCellsHorizontalVerticalWithinRadius(boolean [][] matrix, int i, int j, int radius) {
        if (radius == 0) {
            return 0;
        }

        int total = 0;

        // top
        for (int i1 = 1; i1 <= radius; i1++) {
            try {
                if (matrix[i - i1][j]) {
                    total++;
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {}
        }

        // bottom
        for (int i1 = 1; i1 <= radius; i1++) {
            try {
                if (matrix[i + i1][j]) {
                    total++;
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {}
        }

        // left
        for (int j1 = 1; j1 <= radius; j1++) {
            try {
                if (matrix[i][j - j1]) {
                    total++;
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {}
        }

        // right
        for (int j1 = 1; j1 <= radius; j1++) {
            try {
                if (matrix[i][j + j1]) {
                    total++;
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {}
        }

        return total;
    }

    private static int calculateDistance(int i, int j, int row, int col) {
        int rowDistance = Math.abs(row - i);
        int colDistance = Math.abs(col - j);
        return Math.max(rowDistance, colDistance);
    }

}
