package experimental;

import lombok.AllArgsConstructor;
import lombok.Data;

public class ExperimentalMatrixUtils {

    @Data
    @AllArgsConstructor
    public static class Coordinates {
        public int i; public int j;
    }

    public static Coordinates getCenterCoordinates(long[][] matrix) {
        int i = matrix.length / 2;
        int j = matrix[i].length / 2;
        return new Coordinates(i, j);
    }

    public static Coordinates getRingStartCoordinates(long[][] matrix, int ringNumber) {
        Coordinates c = getCenterCoordinates(matrix);
        c.j += ringNumber;
        return c;
    }


}
