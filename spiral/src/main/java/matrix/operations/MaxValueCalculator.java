package matrix.operations;

class MaxValueCalculator {
    public static long getMaxValue(long[][] matrix) {
        long max = 0;
        for (long[] row : matrix) {
            for (long value : row) {
                if (value > max) {
                    max = value;
                }
            }
        }
        return max;
    }
}
