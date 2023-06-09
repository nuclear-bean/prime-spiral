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

    @Test
    void testIsTwinPrime() {
        Assertions.assertTrue(PrimeUtils.isTwinPrime(3));
        Assertions.assertTrue(PrimeUtils.isTwinPrime(5));
        Assertions.assertTrue(PrimeUtils.isTwinPrime(7));
        Assertions.assertTrue(PrimeUtils.isTwinPrime(11));
        Assertions.assertTrue(PrimeUtils.isTwinPrime(13));
        Assertions.assertTrue(PrimeUtils.isTwinPrime(17));
        Assertions.assertTrue(PrimeUtils.isTwinPrime(19));
        Assertions.assertTrue(PrimeUtils.isTwinPrime(29));
        Assertions.assertTrue(PrimeUtils.isTwinPrime(31));
        Assertions.assertTrue(PrimeUtils.isTwinPrime(41));
        Assertions.assertTrue(PrimeUtils.isTwinPrime(43));
        Assertions.assertTrue(PrimeUtils.isTwinPrime(59));
        Assertions.assertTrue(PrimeUtils.isTwinPrime(61));
        Assertions.assertFalse(PrimeUtils.isTwinPrime(2));
        Assertions.assertFalse(PrimeUtils.isTwinPrime(4));
        Assertions.assertFalse(PrimeUtils.isTwinPrime(6));
    }

    @Test
    void testIsCousinPrime() {
        Assertions.assertTrue(PrimeUtils.isCousinPrime(3));
        Assertions.assertTrue(PrimeUtils.isCousinPrime(7));
        Assertions.assertTrue(PrimeUtils.isCousinPrime(11));
        Assertions.assertTrue(PrimeUtils.isCousinPrime(13));
        Assertions.assertTrue(PrimeUtils.isCousinPrime(17));
        Assertions.assertTrue(PrimeUtils.isCousinPrime(19));
        Assertions.assertTrue(PrimeUtils.isCousinPrime(23));
        Assertions.assertTrue(PrimeUtils.isCousinPrime(877));
        Assertions.assertTrue(PrimeUtils.isCousinPrime(907));
        Assertions.assertTrue(PrimeUtils.isCousinPrime(499));
        Assertions.assertTrue(PrimeUtils.isCousinPrime(613));
        Assertions.assertFalse(PrimeUtils.isCousinPrime(2));
        Assertions.assertFalse(PrimeUtils.isCousinPrime(31));
        Assertions.assertFalse(PrimeUtils.isCousinPrime(149));
    }

    @Test
    void testIsSexyPrime() {
        Assertions.assertTrue(PrimeUtils.isSexyPrime(5));
        Assertions.assertTrue(PrimeUtils.isSexyPrime(7));
        Assertions.assertTrue(PrimeUtils.isSexyPrime(11));
        Assertions.assertTrue(PrimeUtils.isSexyPrime(13));
        Assertions.assertTrue(PrimeUtils.isSexyPrime(17));
        Assertions.assertTrue(PrimeUtils.isSexyPrime(19));
        Assertions.assertTrue(PrimeUtils.isSexyPrime(29));
        Assertions.assertTrue(PrimeUtils.isSexyPrime(31));
        Assertions.assertTrue(PrimeUtils.isSexyPrime(41));
        Assertions.assertTrue(PrimeUtils.isSexyPrime(43));
        Assertions.assertTrue(PrimeUtils.isSexyPrime(59));
        Assertions.assertTrue(PrimeUtils.isSexyPrime(61));
        Assertions.assertFalse(PrimeUtils.isSexyPrime(2));
        Assertions.assertFalse(PrimeUtils.isSexyPrime(3));
        Assertions.assertFalse(PrimeUtils.isSexyPrime(4));
        Assertions.assertFalse(PrimeUtils.isSexyPrime(6));
        Assertions.assertFalse(PrimeUtils.isSexyPrime(8));
        Assertions.assertFalse(PrimeUtils.isSexyPrime(10));
        Assertions.assertFalse(PrimeUtils.isSexyPrime(12));
        Assertions.assertFalse(PrimeUtils.isSexyPrime(14));
        Assertions.assertFalse(PrimeUtils.isSexyPrime(16));
        Assertions.assertFalse(PrimeUtils.isSexyPrime(18));
        Assertions.assertFalse(PrimeUtils.isSexyPrime(20));
        Assertions.assertFalse(PrimeUtils.isSexyPrime(22));
        Assertions.assertFalse(PrimeUtils.isSexyPrime(24));
        Assertions.assertFalse(PrimeUtils.isSexyPrime(26));
        Assertions.assertFalse(PrimeUtils.isSexyPrime(28));
        Assertions.assertFalse(PrimeUtils.isSexyPrime(30));
        Assertions.assertFalse(PrimeUtils.isSexyPrime(32));
        Assertions.assertFalse(PrimeUtils.isSexyPrime(34));
        Assertions.assertFalse(PrimeUtils.isSexyPrime(36));
        Assertions.assertFalse(PrimeUtils.isSexyPrime(38));
        Assertions.assertFalse(PrimeUtils.isSexyPrime(40));
        Assertions.assertFalse(PrimeUtils.isSexyPrime(42));
        Assertions.assertFalse(PrimeUtils.isSexyPrime(44));
        Assertions.assertFalse(PrimeUtils.isSexyPrime(46));
        Assertions.assertFalse(PrimeUtils.isSexyPrime(48));
        Assertions.assertFalse(PrimeUtils.isSexyPrime(50));
        Assertions.assertFalse(PrimeUtils.isSexyPrime(52));
        Assertions.assertFalse(PrimeUtils.isSexyPrime(54));
        Assertions.assertFalse(PrimeUtils.isSexyPrime(56));
    }

    @Test
    void testIsNeighbourPrimeOfGap() {
        Assertions.assertTrue(PrimeUtils.isNeighbourPrimeOfGap(3, 2));
        Assertions.assertTrue(PrimeUtils.isNeighbourPrimeOfGap(89, 12));
    }
}