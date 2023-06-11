package export.csv;

import lombok.extern.log4j.Log4j2;
import utils.MatrixValidator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Log4j2
public final class CSVExporter {

    /**
     * Exports given matrix to CSV file. Each cell is separated by comma. True is represented by 1, false by 0.
     */
    public static void generateCSV(final boolean[][] matrix, final File outputFile) {
        log.info("Starting CSV export");
        validateInputData(matrix);
        generateAndExport(matrix, outputFile);
        log.info("CSV export finished. File saved to: {}", outputFile.getAbsolutePath());
    }

    private static void validateInputData(boolean[][] matrix) {
        MatrixValidator.validateMatrixSize(matrix.length);
        MatrixValidator.validateMatrixSize(matrix[0].length);
        assert matrix.length == matrix[0].length;
    }

    private static void generateAndExport(boolean[][] matrix, File outputFile) {
        try {
            String content = generateFileContent(matrix);
            writeToFile(content, outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Generates CSV file with no commas between values. True is represented by 1, false by 0.
     */
    public static void generateSlimCSV(final boolean[][] matrix, final File outputFile) {
        log.info("Starting slim CSV export");
        validateInputData(matrix);
        exportSlimCSV(matrix, outputFile);
        log.info("Slim CSV export finished. File saved to: {}", outputFile.getAbsolutePath());
    }

    private static void exportSlimCSV(boolean[][] matrix, File outputFile) {
        try {
            String content = generateSlimFileContent(matrix);
            writeToFile(content, outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String generateSlimFileContent(boolean[][] data) {
        StringBuilder sb = new StringBuilder();
        for (boolean[] row : data) {
            for (boolean cell : row) {
                sb.append(cell ? 1 : 0);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private static String generateFileContent(boolean[][] data) {
        StringBuilder sb = new StringBuilder();
        for (boolean[] row : data) {
            for (boolean cell : row) {
                sb.append(cell ? 1 : 0).append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
        }
        return sb.toString();
    }

    private static void writeToFile(String content, File file) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
        writer.write(content);
        writer.flush();
        writer.close();
    }

}
