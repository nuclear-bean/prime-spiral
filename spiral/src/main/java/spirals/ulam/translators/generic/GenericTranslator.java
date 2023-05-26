package spirals.ulam.translators.generic;

public final class GenericTranslator {

    public static Short[][] translate(Boolean[][] matrix, MatrixMappingFunction function) {
        int size = matrix.length;
        Short[][] result = new Short[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = function.map(i, j, matrix);
            }
        }
        return result;
    }

}
