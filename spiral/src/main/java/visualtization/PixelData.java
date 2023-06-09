package visualtization;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a single pixel in an image.
 */
@AllArgsConstructor
@Getter
@Setter
public class PixelData {

    public static final PixelData BLACK = new PixelData(0, 0, 0);
    public static final PixelData WHITE = new PixelData(255, 255, 255);

    public static final PixelData RED = new PixelData(255, 0, 0);
    public static final PixelData GREEN = new PixelData(0, 255, 0);
    public static final PixelData BLUE = new PixelData(0, 0, 255);

    public static final PixelData MAGENTA = new PixelData(255, 0, 255);
    public static final PixelData YELLOW = new PixelData(255, 255, 0);
    public static final PixelData CYAN = new PixelData(0, 255, 255);

    private int red;
    private int green;
    private int blue;
}
