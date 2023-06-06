package visualtization;

import lombok.NonNull;
import lombok.extern.log4j.Log4j2;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Log4j2
public final class DefaultImageExporter {

    public static void generateImage(@NonNull final PixelData[][] pixelData, @NonNull final File outputFile) throws IOException {
        log.info("Starting image export");
        new DefaultImageExporter().doGenerateImage(pixelData, outputFile);
        log.info("Image export finished and saved to: {}", outputFile.getAbsolutePath());
    }

    private void doGenerateImage(@NonNull final PixelData[][] pixelData, @NonNull final File outputFile) throws IOException {
        // todo validate matrix
        // todo validate file
        BufferedImage image = createBufferedImage(pixelData);
        saveBufferedImage(image, outputFile.getAbsolutePath());
    }

    private BufferedImage createBufferedImage(final PixelData[][] pixelData) {
        BufferedImage image = new BufferedImage(pixelData.length, pixelData.length, BufferedImage.TYPE_INT_RGB);
        iterateOverMatrix(pixelData, image);
        return image;
    }

    private void iterateOverMatrix(PixelData[][] pixelData, BufferedImage image) {
        for (int i = 0; i < pixelData.length; i++) {
            for (int j = 0; j < pixelData[i].length; j++) {
                PixelData val = pixelData[i][j];
                image.setRGB(j, i, calculatePixelValue(val));
            }
        }
    }

    private int calculatePixelValue(final PixelData val) {
        return (val.getRed() << 16) + (val.getGreen() << 8) + val.getBlue();
    }

    private void saveBufferedImage(final BufferedImage image, final String outputPath) throws IOException {
        File outputFile = new File(outputPath);
        ImageIO.write(image, "png", outputFile);
    }

}
