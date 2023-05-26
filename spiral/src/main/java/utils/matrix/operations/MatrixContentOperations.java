package utils.matrix.operations;

import java.util.List;

import static utils.matrix.operations.AxialOperations.get_axial_count_of_true_cells_within_radius;
import static utils.matrix.operations.DiagonalOperations.diagonalCountOfTrueCellsWithinRadius;
import static utils.matrix.operations.RetrievalWithinRadiusOperation.*;

/**
 * Utility class to retrieve matrix elements within a given radius from a specified point.
 */
public final class MatrixContentOperations {

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
        return get_elements_within_radius(matrix, i, j, radius);
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
        return countOfTrueCellsWithinRadius(matrix, i, j, radius);
    }

    /**
     * Returns number of true cells placed on a diagonals within a given radius from a specified point.
     * @param matrix matrix to retrieve elements from
     * @param i row index of the specified point
     * @param j column index of the specified point
     * @param radius radius from the specified point
     * @return number of true cells placed on a diagonals within a given radius from a specified point
     */
    public static int getDiagonalCountOfTrueCellsWithinRadius(boolean[][] matrix, int i, int j, int radius) {
        return diagonalCountOfTrueCellsWithinRadius(matrix, i, j, radius);
    }

    /**
     * Returns number of true cells placed on axial within a given radius from a specified point.
     * @param matrix matrix to retrieve elements from
     * @param i row index of the specified point
     * @param j column index of the specified point
     * @param radius radius from the specified point
     * @return number of true cells placed on an axial within a given radius from a specified point
     */
    public static int getAxialCountOfTrueCellWithinRadius(boolean[][] matrix, int i, int j, int radius) {
        return get_axial_count_of_true_cells_within_radius(matrix, i, j, radius);
    }


}
