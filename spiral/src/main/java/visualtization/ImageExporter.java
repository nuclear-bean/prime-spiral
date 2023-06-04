package visualtization;

import lombok.NonNull;

import java.io.File;

@FunctionalInterface
public interface ImageExporter {

    void generateImage(@NonNull final PixelData[][] pixelData, @NonNull final File outputFile) throws ImageExportException;

}
