package experimental;

import experimental.ExperimentalMatrixUtils.Coordinates;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExperimentalMatrixUtilsTest {

    @Test
    void testGetCenterCoordinates_1() {
        long[][] matrix = new long[3][3];
        Coordinates coordinates = ExperimentalMatrixUtils.getCenterCoordinates(matrix);
        assertEquals(1, coordinates.i);
        assertEquals(1, coordinates.j);
    }


    @Test
    void testGetCenterCoordinates_2() {
        long[][] matrix = new long[11][11];
        Coordinates coordinates = ExperimentalMatrixUtils.getCenterCoordinates(matrix);
        assertEquals(5, coordinates.i);
        assertEquals(5, coordinates.j);
    }

    @Test
    void testGetRingStartCoordinates_1() {
        long[][] matrix = new long[3][3];
        Coordinates coordinates = ExperimentalMatrixUtils.getRingStartCoordinates(matrix, 1);
        assertEquals(1, coordinates.i);
        assertEquals(2, coordinates.j);
    }

    @Test
    void testGetRingStartCoordinates_2() {
        long[][] matrix = new long[5][5];
        Coordinates coordinates = ExperimentalMatrixUtils.getRingStartCoordinates(matrix, 2);
        assertEquals(2, coordinates.i);
        assertEquals(4, coordinates.j);
    }


}