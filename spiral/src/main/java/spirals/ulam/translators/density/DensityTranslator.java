package spirals.ulam.translators.density;

import lombok.extern.log4j.Log4j2;
import utils.matrix.MatrixContentOperations;

import java.time.Instant;

@Log4j2
public class DensityTranslator {

    private static Instant lastProgressReport = Instant.MIN;

    public static short[][] translate(DensitySpecification specification) {
        int matrixSize = specification.getMatrix().length;
        short[][] densityMatrix = new short[matrixSize][matrixSize];
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                reportProgress(i, matrixSize);
                densityMatrix[i][j] = calculateDensity(specification, i, j);
            }
        }
        return densityMatrix;
    }

    private static void reportProgress(int i, int matrixSize) {
        if (lastProgressReport.plusSeconds(10).isBefore(Instant.now())) {
            log.info("calculating density... {}%", (i * 100) / matrixSize);
            lastProgressReport = Instant.now();
        }
    }

    private static short calculateDensity(DensitySpecification specification, int i, int j) {
        short density = (short) MatrixContentOperations.getCountOfTrueCellsWithinRadius(
                specification.getMatrix(), i, j, specification.getRadius());
        density += applyPrimeBias(specification, i, j);
        return density;
    }

    private static short applyPrimeBias(DensitySpecification densitySpecification, int i, int j) {
        return densitySpecification.getMatrix()[i][j]
                ? (short) densitySpecification.getPrimeBias()
                : 0;
    }


}
