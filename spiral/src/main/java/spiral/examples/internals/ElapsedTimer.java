package spiral.examples.internals;

import lombok.experimental.UtilityClass;

import java.time.Instant;

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
            System.out.println("(shutdown) Time elapsed: " + (end.toEpochMilli() - start.toEpochMilli()) + " ms");
        }));
    }
}
