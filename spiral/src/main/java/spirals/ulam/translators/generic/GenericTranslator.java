package spirals.ulam.translators.generic;

import lombok.extern.log4j.Log4j2;

import java.time.Instant;

@Log4j2
public final class GenericTranslator {

    private static Instant lastLog = Instant.MIN;

    public static Short[][] translate(boolean[][] matrix, MatrixMappingFunction function) {
        int size = matrix.length;
        Short[][] result = new Short[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                logProgress(i, j, size);
                result[i][j] = function.map(i, j, matrix);
            }
        }
        return result;
    }

    private static void logProgress(int i, int j, int size) {
        int processed = (i * size) + j;
        if (lastLog.plusSeconds(10).isBefore(Instant.now())) {
            log.info("generating mapping... {}%", (processed * 100) / (size * size));
            lastLog = Instant.now();
        }
    }

}
