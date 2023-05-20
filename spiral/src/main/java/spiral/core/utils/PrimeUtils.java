package spiral.core.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PrimeUtils {

    public boolean isPrime(long number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public long[] firstNPrimes(long n) {
        long[] primes = new long[(int) n];
        long count = 0;
        long number = 2;
        while (count < n) {
            if (isPrime(number)) {
                primes[(int) count] = number;
                count++;
            }
            number++;
        }
        return primes;
    }
}
