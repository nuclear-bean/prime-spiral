package experimental;

import lombok.experimental.UtilityClass;

@UtilityClass
public class RingFunctions {

    /**
     * @param n ring number
     * @return nuber of values on a given ring
     */
    public int calculateRingCapacity(int n) {
        return n * 8;
    }

    /**
     * @param n ring number
     * @return smallest value on a given ring
     */
    public long calculateRingMinValue(int n) {
        long val = (2L * n) - 1;
        val = val * val;
        val += 1;
        return val;
    }
}
