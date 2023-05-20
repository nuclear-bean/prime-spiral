package spiral.examples;

import org.junit.jupiter.api.Test;


class BasicSpiralExampleTest {

    // 500  = 150 ms
    // 1000 = 500 ms
    // 1501 = 1400 ms
    // 3001 = 9500 ms

    private static final Integer SIZE = 2001;
    private static final String PATH = "ulam_spiral.png";

    @Test
    public void benchmark() {
        long start = System.currentTimeMillis();

        BasicSpiralExample.main(new String[] {SIZE.toString(), PATH});

        long end = System.currentTimeMillis();
        System.out.println("Time elapsed: " + (end - start) + " ms");
    }

}