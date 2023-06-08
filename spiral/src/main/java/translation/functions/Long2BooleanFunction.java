package translation.functions;

import math.PrimeUtils;

@FunctionalInterface
public interface Long2BooleanFunction {

    Long2BooleanFunction PRIME = PrimeUtils::isPrime;
    Long2BooleanFunction TWIN_PRIMES = PrimeUtils::isTwinPrime;

    boolean apply(long value);
}
