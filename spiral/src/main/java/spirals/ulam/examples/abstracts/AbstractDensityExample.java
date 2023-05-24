package spirals.ulam.examples.abstracts;

import lombok.extern.log4j.Log4j2;
import spirals.ulam.export.image.DensityImageExporter;

import java.io.File;

@Log4j2
public abstract class AbstractDensityExample extends Thread {

    protected int SIZE = 101;
    protected String FILENAME;
    private static final String BASE_OUTPUT_PATH = "output/";

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
        String path = getOutputPath();
        createOutputDir(path);
        DensityImageExporter.generateImage(matrix, path);
        log.info("image generated and saved to {}", path);
    }

    private static void createOutputDir(final String path) {
        new File(new File(path).getParent()).mkdir();
    }

    protected abstract long[][] generateMatrix();

    protected abstract void prepare();

    protected String getOutputPath() {
        String className = this.getClass().getSimpleName().substring(0,3);
        return BASE_OUTPUT_PATH + className + '/' + SIZE + '_' + FILENAME + ".png";
    }
}
