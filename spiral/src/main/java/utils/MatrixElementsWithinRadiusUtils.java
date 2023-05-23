package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to retrieve matrix elements within a given radius from a specified point.
 */
public class MatrixElementsWithinRadiusUtils {

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

    public static int getCountOfTrueCells(boolean[][] matrix, int i, int j, int radius) {
        int count = 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int distance = calculateDistance(i, j, row, col);
                if (distance <= radius && matrix[row][col]) {
                    count++;
                }
            }
        }

        return count;
    }

    private static int calculateDistance(int i, int j, int row, int col) {
        int rowDistance = Math.abs(row - i);
        int colDistance = Math.abs(col - j);
        return Math.max(rowDistance, colDistance);
    }

}
