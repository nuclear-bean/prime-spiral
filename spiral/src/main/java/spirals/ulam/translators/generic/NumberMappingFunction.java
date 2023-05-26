package spirals.ulam.translators.generic;

public interface NumberMappingFunction {
    /**
     * Maps a number to a short. The number is the value of the matrix at the given coordinates.
     * @param i row index
     * @param j column index
     * @param matrix the matrix for reference
     * @return the mapped value
     */
    short map(int i, int j, long[][] matrix);
}
