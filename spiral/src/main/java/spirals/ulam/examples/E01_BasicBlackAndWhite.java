package spirals.ulam.examples;

import lombok.extern.log4j.Log4j2;
import spirals.ulam.examples.abstracts.SimplifiedAbstractExample;
import spirals.ulam.translators.generic.MatrixMappingFunction;

/**
 * Creates basic Ulam spiral and saves it as spirals.ulam.export.image. Primes are mapped to black pixels, non-primes to white.
 */
@Log4j2
public class E01_BasicBlackAndWhite extends SimplifiedAbstractExample {

    public static void main(String[] args) {
        new E01_BasicBlackAndWhite().run();
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
