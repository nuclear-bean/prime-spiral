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

    /**
     * Twin primes are prime numbers that differ from another prime number by two. <br>
     * Learn more: <a href="https://en.wikipedia.org/wiki/Twin_prime">here</a>
     */
    public static boolean isTwinPrime(long number) {
        return isPrime(number) && (isPrime(number - 2) || isPrime(number + 2));
    }

    /**
     * Sexy primes are prime numbers that differ from another prime number by six. <br>
     * Learn more: <a href="https://en.wikipedia.org/wiki/Sexy_prime">here</a>
     */
    public static boolean isSexyPrime(long number) {
        return isPrime(number) && (isPrime(number - 6) || isPrime(number + 6));
    }
}
