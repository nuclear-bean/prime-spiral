package translation.functions;

import visualtization.PixelData;

@FunctionalInterface
public interface Boolean2PixelDataFunction {

    PixelData apply(boolean[][] matrix, int i, int j);

}
