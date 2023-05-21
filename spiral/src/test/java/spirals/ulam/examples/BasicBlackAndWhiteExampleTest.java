package spirals.ulam.examples;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


class BasicBlackAndWhiteExampleTest {

    // 500  = 150 ms
    // 1000 = 500 ms
    // 1501 = 1400 ms
    // 3001 = 9500 ms
    // 15k =  306 s

    private static final Integer SIZE = 10_001;
    private static final String PATH = "ulam_spiral.png";

    @Test
    @Disabled("manual benchmark")
    public void benchmark() {
        long start = System.currentTimeMillis();

        BasicBlackAndWhiteExample.main(new String[] {SIZE.toString(), PATH});

        long end = System.currentTimeMillis();
        System.out.println("Time elapsed: " + (end - start) + " ms");
    }

}