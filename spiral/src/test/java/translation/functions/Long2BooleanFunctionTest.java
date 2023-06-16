package translation.functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Long2BooleanFunctionTest {

    @Test
    void testStatic_PRIME() {
        Long2BooleanFunction function = Long2BooleanFunction.PRIME;
        assertTrue(function.apply(2));
        assertTrue(function.apply(3));
        assertTrue(function.apply(5));
        assertTrue(function.apply(7));
        assertTrue(function.apply(127));
        assertFalse(function.apply(4));
        assertFalse(function.apply(6));
        assertFalse(function.apply(8000008));
    }

    @Test
    void testStatic_TWIN_PRIMES() {
        Long2BooleanFunction function = Long2BooleanFunction.TWIN_PRIMES;
        assertTrue(function.apply(3));
        assertTrue(function.apply(5));
        assertTrue(function.apply(7));
        assertTrue(function.apply(11));
        assertTrue(function.apply(13));
        assertTrue(function.apply(17));
        assertTrue(function.apply(19));
        assertFalse(function.apply(2));
        assertFalse(function.apply(4));
        assertFalse(function.apply(23));
    }

    @Test
    void testCustom() {
        Long2BooleanFunction function = value -> value % 2 == 0;
        assertTrue(function.apply(2));
        assertTrue(function.apply(4));
        assertTrue(function.apply(6));
        assertTrue(function.apply(8));
        assertTrue(function.apply(10));
        assertFalse(function.apply(1));
        assertFalse(function.apply(3));
        assertFalse(function.apply(5));
        assertFalse(function.apply(7));
        assertFalse(function.apply(9));
    }
}