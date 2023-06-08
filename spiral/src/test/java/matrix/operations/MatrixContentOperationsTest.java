package matrix.operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixContentOperationsTest {

    @Test
    void getElementsWithinRadiusTest_1() {
        long[][] matrix = new long[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int i = 0;
        int j = 0;
        int radius = 1;
        int[] actual = MatrixContentOperations.getElementsWithinRadius(matrix, i, j, radius).stream().mapToInt(Long::intValue).toArray();
        int[] expected = new int[]{1, 2, 4, 5};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getElementsWithinRadiusTest_2() {
        long[][] matrix = new long[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int i = 1;
        int j = 1;
        int radius = 1;
        int[] actual = MatrixContentOperations.getElementsWithinRadius(matrix, i, j, radius).stream().mapToInt(Long::intValue).toArray();
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getElementsWithinRadiusTest_3() {
        long[][] matrix = new long[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int i = 1;
        int j = 1;
        int radius = 0;
        int[] actual = MatrixContentOperations.getElementsWithinRadius(matrix, i, j, radius).stream().mapToInt(Long::intValue).toArray();
        int[] expected = new int[]{5};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getElementsWithinRadiusTest_4() {
        long[][] matrix = new long[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int i = 1;
        int j = 2;
        int radius = 2;
        int[] actual = MatrixContentOperations.getElementsWithinRadius(matrix, i, j, radius).stream().mapToInt(Long::intValue).toArray();
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getElementsWithinRadiusTest_5() {
        long[][] matrix = new long[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int i = 1;
        int j = 2;
        int radius = 1;
        int[] actual = MatrixContentOperations.getElementsWithinRadius(matrix, i, j, radius).stream().mapToInt(Long::intValue).toArray();
        int[] expected = new int[]{2, 3, 5, 6, 8, 9};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getCountOfTrueCellsTest_1() {
        boolean[][] matrix = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int actual = MatrixContentOperations.getCountOfTrueCellsWithinRadius(matrix, 1, 1, 1);
        int expected = 9;
        assertEquals(expected, actual);
    }

    @Test
    void getCountOfTrueCellsTest_2() {
        boolean[][] matrix = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int actual = MatrixContentOperations.getCountOfTrueCellsWithinRadius(matrix, 1, 1, 0);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void getCountOfTrueCellsTest_3() {
        boolean[][] matrix = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int actual = MatrixContentOperations.getCountOfTrueCellsWithinRadius(matrix, 0, 0, 1);
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
        int actual = MatrixContentOperations.getCountOfTrueCellsWithinRadius(matrix, 0, 0, 5);
        int expected = 25;
        assertEquals(expected, actual);
    }

    @Test
    void getCountOfTrueCellsTest_5() {
        boolean[][] matrix = new boolean[][]{
                {true, true, false},
                {true, false, false},
                {true, true, true}
        };
        int actual = MatrixContentOperations.getCountOfTrueCellsWithinRadius(matrix, 2, 2, 1);
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    void testGetCountOfTrueCellsHorizontalWithinRadius_1() {
        boolean[][] matrix = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int actual = MatrixContentOperations.getAxialCountOfTrueCellWithinRadius(matrix, 1, 1, 1);
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    void testGetCountOfTrueCellsHorizontalWithinRadius_2() {
        boolean[][] matrix = new boolean[][]{
                {true, false, true},
                {false, true, false},
                {true, false, true}
        };
        int actual = MatrixContentOperations.getAxialCountOfTrueCellWithinRadius(matrix, 1, 1, 1);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void testGetCountOfTrueCellsHorizontalWithinRadius_3() {
        boolean[][] matrix = new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int actual = MatrixContentOperations.getAxialCountOfTrueCellWithinRadius(matrix, 1, 1, 0);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void testGetCountOfTrueCellsHorizontalWithinRadius_4() {
        boolean[][] matrix = new boolean[][]{
                {false, true, true},
                {true, true, true},
                {true, true, true}
        };
        int actual = MatrixContentOperations.getAxialCountOfTrueCellWithinRadius(matrix, 0, 0, 1);
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    void testGetCountOfTrueCellsHorizontalWithinRadius_5() {
        boolean[][] matrix = new boolean[][]{
                {false, true, true},
                {true, true, true},
                {true, true, true}
        };
        int actual = MatrixContentOperations.getAxialCountOfTrueCellWithinRadius(matrix, 0, 0, 2);
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    void testGetCountOfTrueCellsHorizontalWithinRadius_6() {
        boolean[][] matrix = new boolean[][]{
                {false, false, false},
                {true, true, true},
                {false, true, true}
        };
        int actual = MatrixContentOperations.getAxialCountOfTrueCellWithinRadius(matrix, 0, 0, 2);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void testGetCountOfTrueCellsOnDiagonalsWithinRadius_1() {
        boolean[][] matrix = new boolean[][]{
                {true, false, true},
                {false, true, false},
                {true, false, true}
        };
        int actual = MatrixContentOperations.getDiagonalCountOfTrueCellsWithinRadius(matrix, 1, 1, 1);
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    void testGetCountOfTrueCellsOnDiagonalsWithinRadius_2() {
        boolean[][] matrix = new boolean[][]{
                {false, false, false},
                {false, true, false},
                {false, false, false}
        };
        int actual = MatrixContentOperations.getDiagonalCountOfTrueCellsWithinRadius(matrix, 1, 1, 1);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void testGetCountOfTrueCellsOnDiagonalsWithinRadius_3() {
        boolean[][] matrix = new boolean[][]{
                {false, false, false},
                {false, true, false},
                {false, false, false}
        };
        int actual = MatrixContentOperations.getDiagonalCountOfTrueCellsWithinRadius(matrix, 1, 1, 0);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void testGetCountOfTrueCellsOnDiagonalsWithinRadius_4() {
        boolean[][] matrix = new boolean[][]{
                {true, false, false},
                {false, true, false},
                {false, false, false}
        };
        int actual = MatrixContentOperations.getDiagonalCountOfTrueCellsWithinRadius(matrix, 2, 2, 2);
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    void testGetMaxValue_1() {
        long[][] matrix = new long[][]{
                {1, 2, 3},
                {4, 5, 6}
        };
        long actual = MatrixContentOperations.getMaxValue(matrix);
        long expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    void testGetMaxValue_2() {
        long[][] matrix = new long[][]{
                {1, 1, 1},
                {1, 1, 1}
        };
        long actual = MatrixContentOperations.getMaxValue(matrix);
        long expected = 1;
        assertEquals(expected, actual);
    }


}