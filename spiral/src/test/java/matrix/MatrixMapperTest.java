package matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixMapperTest {

    @Test
    public void testShorts2longs() {
        short[][] input = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        long[][] expected = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        long[][] actual = MatrixMapper.shorts2longs(input);
        assertArrayEquals(expected, actual);
    }
}