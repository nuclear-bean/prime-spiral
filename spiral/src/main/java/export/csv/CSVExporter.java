package export.csv;

import java.io.IOException;

public interface CSVExporter {

    void generateCSV(long[][] matrix, String path) throws IOException;
}
