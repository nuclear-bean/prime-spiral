package experimental;

public final class RingFunctions {

    /**
     * @param n ring number
     * @return nuber of values on a given ring
     */
    public static int calculateRingCapacity(int n) {
        return n * 8;
    }

    /**
     * @param n ring number
     * @return smallest value on a given ring
     */
    public static long calculateRingMinValue(int n) {
        long val = (2L * n) - 1;
        val = val * val;
        val += 1;
        return val;
    }

    // todo calculate ring max value
    // todo and test against experimentalgenerator output
}
