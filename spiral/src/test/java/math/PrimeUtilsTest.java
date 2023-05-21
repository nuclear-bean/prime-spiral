package math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PrimeUtilsTest {

    @Test
    void testIsPrime() {
        Assertions.assertFalse(PrimeUtils.isPrime(0));
        Assertions.assertFalse(PrimeUtils.isPrime(1));
        Assertions.assertTrue(PrimeUtils.isPrime(2));
        Assertions.assertTrue(PrimeUtils.isPrime(3));
        Assertions.assertTrue(PrimeUtils.isPrime(5));
        Assertions.assertTrue(PrimeUtils.isPrime(41));
        Assertions.assertTrue(PrimeUtils.isPrime(101));
        Assertions.assertTrue(PrimeUtils.isPrime(997));
        Assertions.assertTrue(PrimeUtils.isPrime(7919));
        Assertions.assertTrue(PrimeUtils.isPrime(15485863));
        Assertions.assertTrue(PrimeUtils.isPrime(179424673));
        Assertions.assertTrue(PrimeUtils.isPrime(32416190071L));
        Assertions.assertFalse(PrimeUtils.isPrime(4));
        Assertions.assertFalse(PrimeUtils.isPrime(6));
        Assertions.assertFalse(PrimeUtils.isPrime(100));
        Assertions.assertFalse(PrimeUtils.isPrime(1000));
        Assertions.assertFalse(PrimeUtils.isPrime(10000));
        Assertions.assertFalse(PrimeUtils.isPrime(100000));
        Assertions.assertFalse(PrimeUtils.isPrime(1000000));
        Assertions.assertFalse(PrimeUtils.isPrime(10000000));
        Assertions.assertFalse(PrimeUtils.isPrime(100000000));
        Assertions.assertFalse(PrimeUtils.isPrime(1000000002));
        Assertions.assertFalse(PrimeUtils.isPrime(10000001231L));
        Assertions.assertFalse(PrimeUtils.isPrime(1000000123123L));
        Assertions.assertFalse(PrimeUtils.isPrime(100000012312345L));
    }

    @Test
    void testFirstNPrimes_01() {
        long[] firstNPrimes = PrimeUtils.firstNPrimes(10);
        Assertions.assertEquals(10, firstNPrimes.length);
        Assertions.assertEquals(2, firstNPrimes[0]);
        Assertions.assertEquals(3, firstNPrimes[1]);
        Assertions.assertEquals(5, firstNPrimes[2]);
        Assertions.assertEquals(7, firstNPrimes[3]);
        Assertions.assertEquals(11, firstNPrimes[4]);
        Assertions.assertEquals(13, firstNPrimes[5]);
        Assertions.assertEquals(17, firstNPrimes[6]);
        Assertions.assertEquals(19, firstNPrimes[7]);
        Assertions.assertEquals(23, firstNPrimes[8]);
        Assertions.assertEquals(29, firstNPrimes[9]);
    }

    @Test
    void testFirstNPrimes_02() {
        long[] firstNPrimes = PrimeUtils.firstNPrimes(1000);
        Assertions.assertEquals(1000, firstNPrimes.length);
        Assertions.assertEquals(2, firstNPrimes[0]);
        Assertions.assertEquals(7919, firstNPrimes[firstNPrimes.length - 1]);
        for (long firstNPrime : firstNPrimes) {
            Assertions.assertTrue(PrimeUtils.isPrime(firstNPrime));
        }
    }
}