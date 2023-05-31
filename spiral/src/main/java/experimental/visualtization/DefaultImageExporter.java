package experimental.visualtization;

import lombok.NonNull;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DefaultImageExporter implements ImageExporter {

    @Override
    public void generateImage(@NonNull final PixelData[][] pixelData, @NonNull final File outputFile) throws ImageExportException {
        // todo validate matrix
        // todo validate file
        BufferedImage image = createBufferedImage(pixelData);
        saveBufferedImage(image, outputFile.getAbsolutePath());
    }

    private BufferedImage createBufferedImage(final PixelData[][] pixelData) {
        int size = pixelData.length;
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < pixelData.length; i++) {
            for (int j = 0; j < pixelData[i].length; j++) {
                PixelData val = pixelData[i][j];
                image.setRGB(j, i, calculatePixelValue(val));
            }
        }

        return image;
    }

    private int calculatePixelValue(final PixelData val) {
        return (val.getRed() << 16) + (val.getGreen() << 8) + val.getBlue();
    }

    private void saveBufferedImage(final BufferedImage image, final String outputPath) {
        try {
            File outputFile = new File(outputPath);
            ImageIO.write(image, "png", outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
