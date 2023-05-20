package spiral.examples;

import lombok.extern.java.Log;
import spiral.core.Matrix;
import spiral.core.generator.BasicGenerator;
import spiral.core.image.BlackAndWhiteImageGenerator;
import spiral.examples.internals.ElapsedTimer;

@Log
public class BasicSpiralExample {

    private static final int SIZE = 15001;
    private static final String PATH = "ulam_spiral.png";

    public static void main(String[] args) {
        log.info("starting...");
        ElapsedTimer.start();
        log.info("generating matrix...");
        Matrix matrix = BasicGenerator.createUlamSpiral(SIZE);
        log.info("generating image...");
        new BlackAndWhiteImageGenerator().generateImage(matrix.getContent(), PATH);
    }
}
