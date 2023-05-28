package spirals.ulam.translators.generic;

@FunctionalInterface
public interface MatrixMappingFunction {

    /**
     * Maps a number to a short. The number is the value of the matrix at the given coordinates.
     * @param i row index
     * @param j column index
     * @param matrix the matrix for reference
     * @return the mapped value
     */
    Short map(int i, int j, boolean[][] matrix);
}
