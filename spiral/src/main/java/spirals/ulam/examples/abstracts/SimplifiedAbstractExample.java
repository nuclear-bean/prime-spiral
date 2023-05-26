package spirals.ulam.examples.abstracts;

import spirals.ulam.export.image.BinaryImageGenerator;
import spirals.ulam.generators.SimpleUlamGenerator;
import spirals.ulam.translators.generic.GenericTranslator;
import spirals.ulam.translators.generic.MatrixMappingFunction;

import static spirals.ulam.translators.BinaryTranslator.translateToBoolean;
import static utils.matrix.MatrixUtils.unwrap;
import static utils.matrix.MatrixUtils.wrap;

public abstract class SimplifiedAbstractExample {

    protected void run() {
        long[][] matrix = SimpleUlamGenerator.generateMatrix(501);
        boolean [][] primeMapping = translateToBoolean(matrix);
        MatrixMappingFunction mappingFunction = defineMatrixMappingFunction();
        Short[][] result = GenericTranslator.translate(wrap(primeMapping), mappingFunction);
        BinaryImageGenerator.generateImage(unwrap(result), "generic.png");      //todo filename generation
    }

    protected abstract MatrixMappingFunction defineMatrixMappingFunction();

}
