package visualtization;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PixelData {

    public static PixelData RED = new PixelData(255, 0, 0);
    public static PixelData GREEN = new PixelData(0, 255, 0);
    public static PixelData BLUE = new PixelData(0, 0, 255);
    public static PixelData BLACK = new PixelData(0, 0, 0);
    public static PixelData WHITE = new PixelData(255, 255, 255);

    private int red;
    private int green;
    private int blue;
}
