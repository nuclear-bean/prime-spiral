package spirals.ulam.export.csv;

import lombok.experimental.UtilityClass;
import spirals.ulam.translators.BinaryTranslator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@UtilityClass
public class SlimCSVExporter {

    public void generateCSV(boolean[][] matrix, String path) throws IOException {
        String content = generateFileContent(matrix);
        writeToFile(content, path);
    }

    private void writeToFile(String content, String path) throws IOException {
        File file = new File(path);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
        writer.write(content);
        writer.flush();
        writer.close();
    }

    private String generateFileContent(boolean[][] data) {
        StringBuilder sb = new StringBuilder();
        for (boolean[] row : data) {
            for (boolean cell : row) {
                char c = cell ? '1' : '0';
                sb.append(c);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
