package spirals.ulam.translators.density;

import utils.MatrixElementsWithinRadiusUtils;

public class ImprovedDensityTranslator {

    public static short[][] translate(DensitySpecification specification) {
        int matrixSize = specification.getMatrix().length;
        short[][] densityMatrix = new short[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                densityMatrix[i][j] = calculateDensity(specification, i, j);
            }
        }
        return densityMatrix;
    }

    private static short calculateDensity(DensitySpecification specification, int i, int j) {
        short density = (short) MatrixElementsWithinRadiusUtils.getCountOfTrueCells(
                specification.getMatrix(), i, j, specification.getRadius());
        density += applyPrimeBias(specification, i, j);
        return density;
    }

    private static short applyPrimeBias(DensitySpecification densitySpecification, int i, int j) {
        if (densitySpecification.getMatrix()[i][j]) {
            return (short) densitySpecification.getPrimeBias();
        } else {
            return 0;
        }
    }


}
