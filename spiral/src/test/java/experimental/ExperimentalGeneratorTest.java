package experimental;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
class ExperimentalGeneratorTest {

    @Test
    void testNW() {
        assertEquals(5, ExperimentalGenerator.NW(1));
        assertEquals(17, ExperimentalGenerator.NW(2));
        assertEquals(37, ExperimentalGenerator.NW(3));
        assertEquals(65, ExperimentalGenerator.NW(4));
    }

    @Test
    void testSE() {
        assertEquals(9, ExperimentalGenerator.SE(1));
        assertEquals(25, ExperimentalGenerator.SE(2));
        assertEquals(49, ExperimentalGenerator.SE(3));
        assertEquals(81, ExperimentalGenerator.SE(4));
    }

    @Test
    void testSW() {
        assertEquals(7, ExperimentalGenerator.SW(1));
        assertEquals(21, ExperimentalGenerator.SW(2));
        assertEquals(43, ExperimentalGenerator.SW(3));
        assertEquals(73, ExperimentalGenerator.SW(4));
    }

    @Test
    void compareWithSimpleUlamGenerator() {
        long[][] matrix = ExperimentalGenerator.generate(151);
        long[][] simpleMatrix = spirals.ulam.generators.SimpleUlamGenerator.generateMatrix(151);
        assertArrayEquals(simpleMatrix, matrix);
    }

    @Test
    @Disabled("Manual benchmark")
    void benchmark() {
        int size = 10_001;
        log.info("Benchmarking with matrix size: " + size);

        log.info("Starting simple generator");
        Instant simpleGeneratorStart = Instant.now();
        spirals.ulam.generators.SimpleUlamGenerator.generateMatrix(size);
        Instant simpleGeneratorEnd = Instant.now();

        log.info("Starting experimental generator");
        Instant experimentalGeneratorStart = Instant.now();
        ExperimentalGenerator.generate(size);
        Instant experimentalGeneratorEnd = Instant.now();

        long simpleGeneratorDuration = simpleGeneratorEnd.toEpochMilli() - simpleGeneratorStart.toEpochMilli();
        long experimentalGeneratorDuration = experimentalGeneratorEnd.toEpochMilli() - experimentalGeneratorStart.toEpochMilli();

        System.out.println("Simple generator duration: " + simpleGeneratorDuration + " ms");
        System.out.println("Experimental generator duration: " + experimentalGeneratorDuration + " ms");
        System.out.println("Experimental generator completed faster by " + (simpleGeneratorDuration - experimentalGeneratorDuration) + " ms");
        System.out.println("Experimental generator is approximately " + simpleGeneratorDuration / experimentalGeneratorDuration + " times faster");

    }

}