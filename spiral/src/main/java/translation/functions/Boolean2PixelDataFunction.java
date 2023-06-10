package translation.functions;

import export.PixelData;

@FunctionalInterface
public interface Boolean2PixelDataFunction {

    PixelData apply(boolean[][] matrix, int i, int j);

}
