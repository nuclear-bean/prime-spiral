package spirals.ulam.examples;

import lombok.extern.log4j.Log4j2;
import spirals.ulam.examples.abstracts.AbstractExample;
import spirals.ulam.export.image.BinaryImageGenerator;
import spirals.ulam.generators.SimpleUlamGenerator;
import spirals.ulam.translators.generic.GenericTranslator;
import spirals.ulam.translators.generic.MatrixElementMappingFunction;

import static spirals.ulam.translators.BinaryTranslator.translateToBoolean;
import static utils.matrix.MatrixUtils.unwrap;
import static utils.matrix.MatrixUtils.wrap;

/**
 * Creates basic Ulam spiral and saves it as spirals.ulam.export.image. Primes are mapped to black pixels, non-primes to white.
 */
@Log4j2
public class E01_BasicBlackAndWhite extends AbstractExample {

    public static void main(String[] args) {
        long[][] matrix = SimpleUlamGenerator.generateMatrix(501);
        boolean [][] primeMapping = translateToBoolean(matrix);
        MatrixElementMappingFunction mappingFunction = defineMatrixElementMappingFunction();
        GenericTranslator translator = new GenericTranslator();
        Short[][] result = translator.translate(wrap(primeMapping), mappingFunction);
        BinaryImageGenerator.generateImage(unwrap(result), "generic.png");
    }

    private static MatrixElementMappingFunction defineMatrixElementMappingFunction() {
        return (i, j, primeMap) -> {
            if (primeMap[i][j]) {
                return (short) 1;
            } else {
                return (short) 0;
            }
        };
    }
}
