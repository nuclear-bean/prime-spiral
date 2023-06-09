package math;

public class PrimeUtils {

    public static boolean isPrime(long number) {
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

    public static long[] firstNPrimes(long n) {
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

    public static boolean isTwinPrime(long number) {
        return isPrime(number) && (isPrime(number - 2) || isPrime(number + 2));
    }
}
