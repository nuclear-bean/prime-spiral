package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixElementsWithinRadiusUtilsTest {

    @Test
    void getElementsWithinRadiusTest_1() {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8 ,9}
        };
        int i = 0;
        int j = 0;
        int radius = 1;
        int[] actual = MatrixElementsWithinRadiusUtils.getElementsWithinRadius(matrix, i, j, radius).stream().mapToInt(Integer::intValue).toArray();
        int[] expected = new int[]{1, 2, 4, 5};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getElementsWithinRadiusTest_2() {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8 ,9}
        };
        int i = 1;
        int j = 1;
        int radius = 1;
        int[] actual = MatrixElementsWithinRadiusUtils.getElementsWithinRadius(matrix, i, j, radius).stream().mapToInt(Integer::intValue).toArray();
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getElementsWithinRadiusTest_3() {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8 ,9}
        };
        int i = 1;
        int j = 1;
        int radius = 0;
        int[] actual = MatrixElementsWithinRadiusUtils.getElementsWithinRadius(matrix, i, j, radius).stream().mapToInt(Integer::intValue).toArray();
        int[] expected = new int[]{5};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getElementsWithinRadiusTest_4() {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8 ,9}
        };
        int i = 1;
        int j = 2;
        int radius = 2;
        int[] actual = MatrixElementsWithinRadiusUtils.getElementsWithinRadius(matrix, i, j, radius).stream().mapToInt(Integer::intValue).toArray();
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getElementsWithinRadiusTest_5() {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8 ,9}
        };
        int i = 1;
        int j = 2;
        int radius = 1;
        int[] actual = MatrixElementsWithinRadiusUtils.getElementsWithinRadius(matrix, i, j, radius).stream().mapToInt(Integer::intValue).toArray();
        int[] expected = new int[]{2, 3, 5, 6, 8, 9};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getCountOfTrueCellsTest_1() {
        boolean[][] matrix = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, true ,true}
        };
        int actual = MatrixElementsWithinRadiusUtils.getCountOfTrueCells(matrix, 1, 1, 1);
        int expected = 9;
        assertEquals(expected, actual);
    }

    @Test
    void getCountOfTrueCellsTest_2() {
        boolean[][] matrix = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, true ,true}
        };
        int actual = MatrixElementsWithinRadiusUtils.getCountOfTrueCells(matrix, 1, 1, 0);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void getCountOfTrueCellsTest_3() {
        boolean[][] matrix = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, true ,true}
        };
        int actual = MatrixElementsWithinRadiusUtils.getCountOfTrueCells(matrix, 0, 0, 1);
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    void getCountOfTrueCellsTest_4() {
        boolean[][] matrix = new boolean[][]{
                {true, true, true, true, true},
                {true, true, true, true, true},
                {true, true, true, true, true},
                {true, true, true, true, true},
                {true, true, true, true, true}
        };
        int actual = MatrixElementsWithinRadiusUtils.getCountOfTrueCells(matrix, 0, 0, 5);
        int expected = 25;
        assertEquals(expected, actual);
    }


}