package spirals.ulam.examples;

import lombok.extern.log4j.Log4j2;
import spirals.ulam.examples.abstracts.AbstractExample;
import spirals.ulam.translators.generic.MatrixMappingFunction;
import utils.OutputPathProvider;

/**
 * Creates basic Ulam spiral and saves it as spirals.ulam.export.image. Primes are mapped to black pixels, non-primes to white.
 */
@Log4j2
public class E01_BasicBlackAndWhite extends AbstractExample {

    public static void main(String[] args) {
        int size = 10_001;
        final String outputPath =
                OutputPathProvider.getOutputPath("basic_black_and_white", size, ".png", E01_BasicBlackAndWhite.class);
        new E01_BasicBlackAndWhite().run(size, outputPath);
    }

    @Override
    public MatrixMappingFunction defineMatrixMappingFunction() {
        return (i, j, primeMap) -> {
            if (primeMap[i][j]) {
                return (short) 1;
            } else {
                return (short) 0;
            }
        };
    }
}
