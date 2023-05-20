package spiral.examples;

import lombok.extern.java.Log;
import spiral.core.Matrix;
import spiral.core.generator.BasicGenerator;
import spiral.core.image.BlackAndWhiteImageGenerator;
import spiral.examples.internals.ElapsedTimer;

@Log
public class BasicSpiralExample {

    public static void main(String[] args) {
        log.info("starting...");
        int SIZE = 15001;
        ElapsedTimer.start();
        log.info("generating matrix...");
        Matrix matrix = BasicGenerator.createUlamSpiral(SIZE);
        log.info("generating image...");
        new BlackAndWhiteImageGenerator().generateImageFromMatrix(matrix.getContent(),"ulam_spiral.png");
    }
}
