package export.csv;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import spirals.ulam.translators.BinaryTranslator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BasicCSVExporter implements CSVExporter {

    private static BasicCSVExporter instance;

    public static BasicCSVExporter getInstance() {
        if (instance == null) {
            instance = new BasicCSVExporter();
        }
        return instance;
    }

    @Override
    public void generateCSV(long[][] matrix, String path) throws IOException {
        long[][] data = BinaryTranslator.translate(matrix);
        String content = generateFileContent(data);
        writeToFile(content, path);
    }

    private void writeToFile(String content, String path) throws IOException {
        File file = new File(path);
        FileWriter writer = new FileWriter(file,false);
        writer.write(content);
        writer.flush();
        writer.close();
    }

    private String generateFileContent(long[][] data) {
        StringBuilder sb = new StringBuilder();
        for (long[] row : data) {
            for (long cell : row) {
                sb.append(cell).append(",");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
