package utils;

import lombok.extern.log4j.Log4j2;

import java.time.Instant;

@Log4j2
public final class ElapsedTimer {

    private static Instant start;
    private static Instant end;

    public static void start() {
        start = Instant.now();
        createShutdownHook();
    }

    private static void createShutdownHook() {
        Thread hook = createHookThread();
        Runtime.getRuntime().addShutdownHook(hook);
    }

    private static Thread createHookThread() {
        Thread hook = new Thread(() -> {
            end = Instant.now();
            long elapsed = end.toEpochMilli() - start.toEpochMilli();
            log.info("(shutdown) Time elapsed: {} ms", elapsed);
        });
        hook.setName("timer");
        return hook;
    }
}
