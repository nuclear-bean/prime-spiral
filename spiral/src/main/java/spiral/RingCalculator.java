package spiral;

import lombok.experimental.UtilityClass;

@UtilityClass
public class RingCalculator {

    public long[] calculateRingContent(int n) {
        int capacity = calculateRingCapacity(n);
        long [] result = new long[capacity];
        result[0] = calculateRingMinValue(n);
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i-1] + 1;
        }
        return result;
    }

    private int calculateRingCapacity(int n) {
        return n * 8;
    }

    private long calculateRingMinValue(int n) {
        long val = (2L * n) - 1;
        val = val * val;
        val += 1;
        return val;
    }
}
