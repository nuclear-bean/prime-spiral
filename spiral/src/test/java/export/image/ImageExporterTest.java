package export.image;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ResultOfMethodCallIgnored")
class ImageExporterTest {

    PixelData TOP_LEFT = new PixelData(100, 50, 69);
    PixelData TOP_MIDDLE = new PixelData(50, 100, 42);
    PixelData TOP_RIGHT = new PixelData(44, 100, 50);
    PixelData MIDDLE_LEFT = new PixelData(21, 50, 100);
    PixelData MIDDLE_MIDDLE = new PixelData(50, 20, 100);
    PixelData MIDDLE_RIGHT = new PixelData(100, 15, 50);
    PixelData BOTTOM_LEFT = new PixelData(100, 50, 3);
    PixelData BOTTOM_MIDDLE = new PixelData(50, 100, 2);
    PixelData BOTTOM_RIGHT = new PixelData(1, 100, 50);

    @Test
    void testSuccessfulImageGeneration() {
        try {
            // given
            PixelData [][] matrix =  {
                    {TOP_LEFT, TOP_MIDDLE, TOP_RIGHT},
                    {MIDDLE_LEFT, MIDDLE_MIDDLE, MIDDLE_RIGHT},
                    {BOTTOM_LEFT, BOTTOM_MIDDLE, BOTTOM_RIGHT}
            };

            //when
            ImageExporter.generateImage(matrix, new File("test.png"));

            // then
            assertTrue(new File("test.png").exists());
            BufferedImage img = ImageIO.read(new File("test.png"));
            assertEquals(3, img.getWidth());
            assertEquals(3, img.getHeight());
            int topLeftValue = img.getRGB(0, 0);
            assertEquals(100, (topLeftValue >> 16) & 0xFF);
            assertEquals(50, (topLeftValue >> 8) & 0xFF);
            assertEquals(69, topLeftValue & 0xFF);
            int topMiddleValue = img.getRGB(1, 0);
            assertEquals(50, (topMiddleValue >> 16) & 0xFF);
            assertEquals(100, (topMiddleValue >> 8) & 0xFF);
            assertEquals(42, topMiddleValue & 0xFF);
            int topRightValue = img.getRGB(2, 0);
            assertEquals(44, (topRightValue >> 16) & 0xFF);
            assertEquals(100, (topRightValue >> 8) & 0xFF);
            assertEquals(50, topRightValue & 0xFF);
            int middleLeftValue = img.getRGB(0, 1);
            assertEquals(21, (middleLeftValue >> 16) & 0xFF);
            assertEquals(50, (middleLeftValue >> 8) & 0xFF);
            assertEquals(100, middleLeftValue & 0xFF);
            int middleMiddleValue = img.getRGB(1, 1);
            assertEquals(50, (middleMiddleValue >> 16) & 0xFF);
            assertEquals(20, (middleMiddleValue >> 8) & 0xFF);
            assertEquals(100, middleMiddleValue & 0xFF);
            int middleRightValue = img.getRGB(2, 1);
            assertEquals(100, (middleRightValue >> 16) & 0xFF);
            assertEquals(15, (middleRightValue >> 8) & 0xFF);
            assertEquals(50, middleRightValue & 0xFF);
            int bottomLeftValue = img.getRGB(0, 2);
            assertEquals(100, (bottomLeftValue >> 16) & 0xFF);
            assertEquals(50, (bottomLeftValue >> 8) & 0xFF);
            assertEquals(3, bottomLeftValue & 0xFF);
            int bottomMiddleValue = img.getRGB(1, 2);
            assertEquals(50, (bottomMiddleValue >> 16) & 0xFF);
            assertEquals(100, (bottomMiddleValue >> 8) & 0xFF);
            assertEquals(2, bottomMiddleValue & 0xFF);
            int bottomRightValue = img.getRGB(2, 2);
            assertEquals(1, (bottomRightValue >> 16) & 0xFF);
            assertEquals(100, (bottomRightValue >> 8) & 0xFF);
            assertEquals(50, bottomRightValue & 0xFF);

            // cleanup
            new File("test.png").delete();
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void matrixTooSmall() {
        PixelData[][] data = new PixelData[1][1];
        assertThrows(IllegalArgumentException.class, () -> ImageExporter.generateImage(data, new File("test.png")));
    }

    @Test
    void evenMatrix() {
        PixelData[][] data = new PixelData[12][12];
        assertThrows(IllegalArgumentException.class, () -> ImageExporter.generateImage(data, new File("test.png")));
    }

    @Test
    void notSquareMatrix() {
        PixelData[][] data = new PixelData[12][13];
        assertThrows(IllegalArgumentException.class, () -> ImageExporter.generateImage(data, new File("test.png")));
    }

}