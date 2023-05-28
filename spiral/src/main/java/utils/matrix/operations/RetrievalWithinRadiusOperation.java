package utils.matrix.operations;

import java.util.ArrayList;
import java.util.List;

class RetrievalWithinRadiusOperation {

    /**
     * Returns a list of elements within a given radius from a specified point.
     *
     * @param matrix matrix to retrieve elements from
     * @param i      row index of the specified point
     * @param j      column index of the specified point
     * @param radius radius from the specified point
     * @return list of elements within a given radius from a specified point
     */
    static List<Integer> get_elements_within_radius(int[][] matrix, int i, int j, int radius) {
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
    static int countOfTrueCellsWithinRadius(boolean[][] matrix, int i, int j, int radius) {
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

    private static int calculateDistance(int i, int j, int row, int col) {
        int rowDistance = Math.abs(row - i);
        int colDistance = Math.abs(col - j);
        return Math.max(rowDistance, colDistance);
    }
}
