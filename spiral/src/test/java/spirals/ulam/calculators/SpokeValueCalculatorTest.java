package spirals.ulam.calculators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpokeValueCalculatorTest {

    @Test
    void testSE() {
        assertEquals(1, SpokeValueCalculator.SE(0));
        assertEquals(9, SpokeValueCalculator.SE(1));
        assertEquals(25, SpokeValueCalculator.SE(2));
        assertEquals(49, SpokeValueCalculator.SE(3));
        assertEquals(81, SpokeValueCalculator.SE(4));
    }

    @Test
    void testNW() {
        assertEquals(1, SpokeValueCalculator.NW(0));
        assertEquals(5, SpokeValueCalculator.NW(1));
        assertEquals(17, SpokeValueCalculator.NW(2));
        assertEquals(37, SpokeValueCalculator.NW(3));
        assertEquals(65, SpokeValueCalculator.NW(4));
        assertEquals(101, SpokeValueCalculator.NW(5));
        assertEquals(145, SpokeValueCalculator.NW(6));
        assertEquals(197, SpokeValueCalculator.NW(7));
    }

    @Test
    void testNE() {
        assertEquals(1, SpokeValueCalculator.NE(0));
        assertEquals(3, SpokeValueCalculator.NE(1));
        assertEquals(13, SpokeValueCalculator.NE(2));
        assertEquals(31, SpokeValueCalculator.NE(3));
        assertEquals(57, SpokeValueCalculator.NE(4));
        assertEquals(91, SpokeValueCalculator.NE(5));
        assertEquals(133, SpokeValueCalculator.NE(6));
        assertEquals(183, SpokeValueCalculator.NE(7));
    }

    @Test
    void testSW() {
        assertEquals(1, SpokeValueCalculator.SW(0));
        assertEquals(7, SpokeValueCalculator.SW(1));
        assertEquals(21, SpokeValueCalculator.SW(2));
        assertEquals(43, SpokeValueCalculator.SW(3));
        assertEquals(73, SpokeValueCalculator.SW(4));
        assertEquals(111, SpokeValueCalculator.SW(5));
        assertEquals(157, SpokeValueCalculator.SW(6));
        assertEquals(211, SpokeValueCalculator.SW(7));
    }

}