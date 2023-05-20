package spiral.experimental;

import spiral.core.Matrix;
import spiral.core.generator.BasicGenerator;
import spiral.core.image.BlackAndWhiteImageGenerator;
import spiral.core.utils.annotations.Experimental;

import java.time.Instant;

@Experimental
public class Main {

    private static final int SIZE = 1501;

    public static void main(String[] args) {
        Instant start = Instant.now();
        Matrix matrix = BasicGenerator.createUlamSpiral(SIZE);
        new BlackAndWhiteImageGenerator().generateImageFromMatrix(matrix.getContent(),"ulam_spiral.png");
        Instant end = Instant.now();
        System.out.println(SIZE + " = matrix side. generation completed. Time elapsed: " + (end.toEpochMilli() - start.toEpochMilli()) + " ms");
    }

}
