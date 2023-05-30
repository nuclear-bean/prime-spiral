package matrix;

import org.junit.jupiter.api.Assertions;
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

    @Test
    void testMapToBoolean_AllOnes() {
        short[][] matrix = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        boolean[][] expected = {{true, true, true}, {true, true, true}, {true, true, true}};
        boolean[][] actual = MatrixMapper.mapToBoolean(matrix);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testMapToBoolean_AllZeros() {
        short[][] matrix = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        boolean[][] expected = {{false, false, false}, {false, false, false}, {false, false, false}};
        boolean[][] actual = MatrixMapper.mapToBoolean(matrix);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testMapToBoolean_MixedValues() {
        short[][] matrix = {{1, 0, 1}, {0, 1, 0}, {1, 1, 0}};
        boolean[][] expected = {{true, false, true}, {false, true, false}, {true, true, false}};
        boolean[][] actual = MatrixMapper.mapToBoolean(matrix);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testMapToBoolean_InvalidValue() {
        short[][] matrix = {{1, 2, 0}, {1, 1, 0}, {1, 0, 1}};
        Assertions.assertThrows(IllegalArgumentException.class, () -> MatrixMapper.mapToBoolean(matrix));
    }

}