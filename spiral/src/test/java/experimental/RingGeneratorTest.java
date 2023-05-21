package experimental;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import experimental.RingGenerator;

import java.util.stream.LongStream;

class RingGeneratorTest {

    @Test
    void calculateRingContentTest_1() {
        int ring = 1;
        long [] actual = RingGenerator.ringContent(ring);
        long [] expected = LongStream.rangeClosed(2, 9).toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void calculateRingContentTest_2() {
        int ring = 2;
        long [] actual = RingGenerator.ringContent(ring);
        long [] expected = LongStream.rangeClosed(10, 25).toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void calculateRingContentTest_3() {
        int ring = 3;
        long [] actual = RingGenerator.ringContent(ring);
        long [] expected = LongStream.rangeClosed(26, 49).toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void calculateRingContentTest_4() {
        int ring = 4;
        long [] actual = RingGenerator.ringContent(ring);
        long [] expected = LongStream.rangeClosed(50, 81).toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void calculateRingContentTest_5() {
        int ring = 5;
        long [] actual = RingGenerator.ringContent(ring);
        long [] expected = LongStream.rangeClosed(82, 121).toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

}