package export.image;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RGBChannelTest {

    @Test
    void testEnum() {
        assertEquals(3, RGBChannel.values().length);
        assertEquals(RGBChannel.RED, RGBChannel.valueOf("RED"));
        assertEquals(RGBChannel.GREEN, RGBChannel.valueOf("GREEN"));
        assertEquals(RGBChannel.BLUE, RGBChannel.valueOf("BLUE"));
    }

}