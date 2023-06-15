package export.csv;

import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVExporterTest {

    static File testFile = new File("test.csv");
    static boolean [][] input = new boolean[][] {
            {true, false, true},
            {false, true, false},
            {true, false, true}
    };


    @Test
    @SneakyThrows
    void testCsvExport() {
        // when
        CSVExporter.generateCSV(input, testFile);

        // then
        assertTrue(testFile.exists());
        List<String> csv = readCSV(testFile);

        assertEquals(csv.get(0), "1,0,1");
        assertEquals(csv.get(1), "0,1,0");
        assertEquals(csv.get(2), "1,0,1");
    }

    @Test
    @SneakyThrows
    void testSlimCsvExport() {
        // when
        CSVExporter.generateSlimCSV(input, testFile);

        // then
        assertTrue(testFile.exists());
        List<String> csv = readCSV(testFile);

        assertEquals(csv.get(0), "101");
        assertEquals(csv.get(1), "010");
        assertEquals(csv.get(2), "101");
    }

    @Test
    void testInvalidPath() {
        assertThrows(FileNotFoundException.class, () -> CSVExporter.generateCSV(input, new File("\\akdfnakj")));
    }

    @Test
    void testInvalidPathSlim() {
        assertThrows(FileNotFoundException.class, () -> CSVExporter.generateSlimCSV(input, new File("\\akdfnakj")));
    }

    private List<String> readCSV(File file) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            Assertions.fail(e);
        }
        return lines;
    }

    @AfterEach
    void tearDown() {
        try {
            //noinspection ResultOfMethodCallIgnored
            testFile.delete();
        } catch (Exception ignored) {}
    }

}