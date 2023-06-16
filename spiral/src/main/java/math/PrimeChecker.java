package math;

final class PrimeChecker {
    
    static boolean isPrime(long number) {
        return number > 1 && hasNoAdditionalDividers(number);
    }

    private static boolean hasNoAdditionalDividers(long number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
