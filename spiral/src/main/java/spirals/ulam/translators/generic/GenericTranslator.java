package spirals.ulam.translators.generic;

public class GenericTranslator {

    public Short[][] translate(Boolean[][] matrix, MatrixElementMappingFunction function) {
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
