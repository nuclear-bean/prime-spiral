package spiral;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

class MatrixTimeTest {

    static Matrix matrix;

    @BeforeEach
    void initializeMatrix() {
        int size = 101;
        matrix = new Matrix(size);
        long[][] content = new long[size][size];
        MatrixFiller.ulamSpiralCounterClockwise(content);
        matrix.fillWith(content);
    }

    @Test
    void measureMatrixGenerationTime() {
        Instant instant = Instant.now();

        int size = 1001;
        long[][] content = new long[size][size];
        MatrixFiller.ulamSpiralCounterClockwise(content);

        Instant end = Instant.now();
        Duration duration = Duration.between(instant, end);
        System.out.println(formatDuration(duration));
    }


    public static String formatDuration(Duration duration) {
        long seconds = duration.getSeconds();
        long absSeconds = Math.abs(seconds);
        int nanoAdjustment = duration.getNano();
        long minutes = absSeconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;
        long years = days / 365;

        StringBuilder builder = new StringBuilder();
        if (years > 0) {
            builder.append(years).append(" year").append(years > 1 ? "s" : "").append(", ");
        }
        if (days > 0) {
            builder.append(days % 365).append(" day").append(days % 365 > 1 ? "s" : "").append(", ");
        }
        if (hours > 0) {
            builder.append(hours % 24).append(" hour").append(hours % 24 > 1 ? "s" : "").append(", ");
        }
        if (minutes > 0) {
            builder.append(minutes % 60).append(" minute").append(minutes % 60 > 1 ? "s" : "").append(", ");
        }
        if (absSeconds > 0) {
            builder.append(absSeconds % 60).append(" second").append(absSeconds % 60 > 1 ? "s" : "");
            if (nanoAdjustment > 0) {
                builder.append(" and ").append(nanoAdjustment).append(" nanosecond").append(nanoAdjustment > 1 ? "s" : "");
            }
        }
        if (builder.toString().isEmpty()) {
            builder.append("0 seconds");
        }
        return builder.toString();
    }





}