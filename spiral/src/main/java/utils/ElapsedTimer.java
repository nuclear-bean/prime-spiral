package utils;

import lombok.experimental.UtilityClass;
import lombok.extern.java.Log;

import java.time.Instant;

@Log
@UtilityClass
public final class ElapsedTimer {

    private Instant start;
    private Instant end;

    public void start() {
        start = Instant.now();
        createShutdownHook();
    }

    private static void createShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            end = Instant.now();
            log.info("(shutdown) Time elapsed: " + (end.toEpochMilli() - start.toEpochMilli()) + " ms");
        }));
    }
}
