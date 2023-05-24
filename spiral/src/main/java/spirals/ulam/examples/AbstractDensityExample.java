package spirals.ulam.examples;

import lombok.extern.log4j.Log4j2;
import spirals.ulam.export.image.DensityImageExporter;

@Log4j2
public abstract class AbstractDensityExample extends Thread {

    protected int SIZE = 101;
    protected String FILENAME;
    protected String OUTPUT_PATH = "output/";

    @Override
    public void run() {
        log.info("starting");
        prepare();
        long [][] matrix = generateMatrix();
        short [][] mapped = mapMatrix(matrix);
        generateImage(mapped);
        log.info("generation completed");
    }

    protected abstract short[][] mapMatrix(final long[][] matrix);

    protected void generateImage(short [][] matrix) {
        log.info("generating export image...");
        String path = getPath();
        DensityImageExporter.generateImage(matrix, path);
        log.info("image generated and saved to {}", path);
    }

    protected abstract long[][] generateMatrix();

    protected abstract void prepare();

    protected String getPath() {
        return OUTPUT_PATH + SIZE + '_' + FILENAME + ".png";
    }
}
