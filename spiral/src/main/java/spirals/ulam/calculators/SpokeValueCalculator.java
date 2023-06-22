package spirals.ulam.calculators;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SpokeValueCalculator {

    public static long SE(int ringNumber) {
        long val = (ringNumber * 2L) + 1L;
        return val * val;
    }

    public static long NW(int ringNumber) {
        long val = (ringNumber * 2L) + 1L;
        long valSquared = val * val;
        return valSquared - (4L * ringNumber);
    }

    public static long SW(int ringNumber) {
        long val = (ringNumber * 2L) + 1L;
        long valSquared = val  * val ;
        return valSquared - (2L * ringNumber);
    }

    public static long NE(int ringNumber) {
        long val = (ringNumber * 2L) + 1L;
        long valSquared = val * val;
        return valSquared - (6L * ringNumber);
    }


}
