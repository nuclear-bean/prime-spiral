package export.csv;

import java.io.IOException;

public interface CSVGenerator {

    void generateCSV(long[][] matrix, String path) throws IOException;
}
