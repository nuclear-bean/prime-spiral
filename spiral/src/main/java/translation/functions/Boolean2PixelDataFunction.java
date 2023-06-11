package translation.functions;

import export.image.PixelData;

@FunctionalInterface
public interface Boolean2PixelDataFunction {

    PixelData apply(boolean[][] matrix, int i, int j);

}
