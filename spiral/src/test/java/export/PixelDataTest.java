package export;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PixelDataTest {

    @Test
    void testStaticConstants_BLACK() {
        PixelData black = PixelData.BLACK;
        Assertions.assertEquals(0, black.getRed());
        Assertions.assertEquals(0, black.getGreen());
        Assertions.assertEquals(0, black.getBlue());
    }

    @Test
    void testStaticConstants_WHITE() {
        PixelData white = PixelData.WHITE;
        Assertions.assertEquals(255, white.getRed());
        Assertions.assertEquals(255, white.getGreen());
        Assertions.assertEquals(255, white.getBlue());
    }

    @Test
    void testStaticConstants_RED() {
        PixelData red = PixelData.RED;
        Assertions.assertEquals(255, red.getRed());
        Assertions.assertEquals(0, red.getGreen());
        Assertions.assertEquals(0, red.getBlue());
    }

    @Test
    void testStaticConstants_GREEN() {
        PixelData green = PixelData.GREEN;
        Assertions.assertEquals(0, green.getRed());
        Assertions.assertEquals(255, green.getGreen());
        Assertions.assertEquals(0, green.getBlue());
    }

    @Test
    void testStaticConstants_BLUE() {
        PixelData blue = PixelData.BLUE;
        Assertions.assertEquals(0, blue.getRed());
        Assertions.assertEquals(0, blue.getGreen());
        Assertions.assertEquals(255, blue.getBlue());
    }

    @Test
    void testStaticConstants_MAGENTA() {
        PixelData magenta = PixelData.MAGENTA;
        Assertions.assertEquals(255, magenta.getRed());
        Assertions.assertEquals(0, magenta.getGreen());
        Assertions.assertEquals(255, magenta.getBlue());
    }

    @Test
    void testStaticConstants_YELLOW() {
        PixelData yellow = PixelData.YELLOW;
        Assertions.assertEquals(255, yellow.getRed());
        Assertions.assertEquals(255, yellow.getGreen());
        Assertions.assertEquals(0, yellow.getBlue());
    }

    @Test
    void testStaticConstants_CYAN() {
        PixelData cyan = PixelData.CYAN;
        Assertions.assertEquals(0, cyan.getRed());
        Assertions.assertEquals(255, cyan.getGreen());
        Assertions.assertEquals(255, cyan.getBlue());
    }

    @Test
    void testSetterAndGetter() {
        PixelData pixelData = new PixelData(1, 2, 3);
        Assertions.assertEquals(1, pixelData.getRed());
        Assertions.assertEquals(2, pixelData.getGreen());
        Assertions.assertEquals(3, pixelData.getBlue());
        pixelData.setRed(4);
        pixelData.setGreen(5);
        pixelData.setBlue(6);
        Assertions.assertEquals(4, pixelData.getRed());
        Assertions.assertEquals(5, pixelData.getGreen());
        Assertions.assertEquals(6, pixelData.getBlue());
    }

}