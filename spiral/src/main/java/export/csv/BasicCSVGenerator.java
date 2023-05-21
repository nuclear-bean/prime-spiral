package export.csv;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import math.PrimeUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BasicCSVGenerator implements CSVGenerator {

    private static BasicCSVGenerator instance;

    public static BasicCSVGenerator getInstance() {
        if (instance == null) {
            instance = new BasicCSVGenerator();
        }
        return instance;
    }

    @Override
    public void generateCSV(long[][] matrix, String path) throws IOException {
        long[][] data = translateToOnesAndZeros(matrix);
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

    private long[][] translateToOnesAndZeros(long[][] matrix) {
        long[][] result = new long[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[i][j] = PrimeUtils.isPrime(matrix[i][j]) ? 1 : 0;
            }
        }
        return result;
    }
}
