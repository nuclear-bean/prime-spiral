package math;

public class PrimeUtils {

    private static final int TWIN_PRIME_GAP = 2;
    private static final int COUSIN_PRIME_GAP = 4;
    private static final int SEXY_PRIME_GAP = 6;

    public static boolean isPrime(long number) {
        return PrimeChecker.isPrime(number);
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

    /**
     * Twin primes are prime numbers that differ from another prime number by two. <br>
     * Learn more: <a href="https://en.wikipedia.org/wiki/Twin_prime">here</a>
     */
    public static boolean isTwinPrime(long number) {
        return isNeighbourPrimeOfGap(number, TWIN_PRIME_GAP);
    }

    public static boolean isCousinPrime(long number) {
        return isNeighbourPrimeOfGap(number, COUSIN_PRIME_GAP);
    }

    /**
     * Sexy primes are prime numbers that differ from another prime number by six. <br>
     * Learn more: <a href="https://en.wikipedia.org/wiki/Sexy_prime">here</a>
     */
    public static boolean isSexyPrime(long number) {
        return isNeighbourPrimeOfGap(number, SEXY_PRIME_GAP);
    }

    public static boolean isNeighbourPrimeOfGap(long number, int gap) {
        return isPrime(number) && (isPrime(number - gap) || isPrime(number + gap));
    }
}
