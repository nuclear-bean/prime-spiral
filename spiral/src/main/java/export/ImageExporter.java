package export;

import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import utils.MatrixValidator;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static utils.export.OutputFileValidator.*;

@Log4j2
public final class ImageExporter {

    public static void generateImage(@NonNull final PixelData[][] pixelData, @NonNull final File outputFile) throws IOException {
        log.info("Starting image export");
        validateInputData(pixelData, outputFile);
        doGenerateImage(pixelData, outputFile);
        log.info("Image export finished and saved to: {}", outputFile.getAbsolutePath());
    }

    private static void validateInputData(PixelData[][] pixelData, File outputFile) {
        validateOutputFile(outputFile);
        MatrixValidator.validateMatrixSize(pixelData.length);
        MatrixValidator.validateMatrixSize(pixelData[0].length);
        assert pixelData.length == pixelData[0].length;
    }

    private static void doGenerateImage(@NonNull final PixelData[][] pixelData, @NonNull final File outputFile) throws IOException {
        BufferedImage image = createBufferedImage(pixelData);
        saveBufferedImage(image, outputFile.getAbsolutePath());
    }

    private static BufferedImage createBufferedImage(final PixelData[][] pixelData) {
        BufferedImage image = new BufferedImage(pixelData.length, pixelData.length, BufferedImage.TYPE_INT_RGB);
        iterateOverMatrix(pixelData, image);
        return image;
    }

    private static void iterateOverMatrix(PixelData[][] pixelData, BufferedImage image) {
        for (int i = 0; i < pixelData.length; i++) {
            for (int j = 0; j < pixelData[i].length; j++) {
                PixelData val = pixelData[i][j];
                image.setRGB(j, i, calculatePixelValue(val));
            }
        }
    }

    private static int calculatePixelValue(final PixelData val) {
        return (val.getRed() << 16) + (val.getGreen() << 8) + val.getBlue();
    }

    private static void saveBufferedImage(final BufferedImage image, final String outputPath) throws IOException {
        File outputFile = new File(outputPath);
        ImageIO.write(image, "png", outputFile);
    }

}
