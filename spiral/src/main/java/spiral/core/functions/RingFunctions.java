package spiral.core.functions;

import lombok.experimental.UtilityClass;

@UtilityClass
public class RingFunctions {

    public int calculateRingCapacity(int n) {
        return n * 8;
    }

    public long calculateRingMinValue(int n) {
        long val = (2L * n) - 1;
        val = val * val;
        val += 1;
        return val;
    }
}
