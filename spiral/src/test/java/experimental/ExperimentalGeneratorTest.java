package experimental;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
class ExperimentalGeneratorTest {

    @Test
    void compareWithSimpleUlamGenerator() {
        long[][] matrix = ExperimentalGenerator.generate(151);
        long[][] simpleMatrix = spirals.ulam.generators.SimpleUlamGenerator.generateMatrix(151);
        assertArrayEquals(simpleMatrix, matrix);
    }

    @Test
    @Disabled("Manual benchmark")
    void benchmark() {
        int size = 5001;
        log.info("Benchmarking with matrix size: " + size);

        log.info("Starting simple generator");
        Instant simpleGeneratorStart = Instant.now();
        long [][] simpleMatrix = spirals.ulam.generators.SimpleUlamGenerator.generateMatrix(size);
        Instant simpleGeneratorEnd = Instant.now();

        log.info("Starting experimental generator");
        Instant experimentalGeneratorStart = Instant.now();
        long [][] experimentalMatrix = ExperimentalGenerator.generate(size);
        Instant experimentalGeneratorEnd = Instant.now();

        long simpleGeneratorDuration = simpleGeneratorEnd.toEpochMilli() - simpleGeneratorStart.toEpochMilli();
        long experimentalGeneratorDuration = experimentalGeneratorEnd.toEpochMilli() - experimentalGeneratorStart.toEpochMilli();

        System.out.println("Simple generator duration: " + simpleGeneratorDuration + " ms");
        System.out.println("Experimental generator duration: " + experimentalGeneratorDuration + " ms");
        System.out.println("Experimental generator completed faster by " + (simpleGeneratorDuration - experimentalGeneratorDuration) + " ms");
        System.out.println("Experimental generator is approximately " + simpleGeneratorDuration / experimentalGeneratorDuration + " times faster");

        assertArrayEquals(simpleMatrix, experimentalMatrix);
    }

}