package utils.export;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class OutputFileValidatorTest {

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @BeforeAll
    static void setup() throws IOException {
        File file = new File("non_writeable_file");
        file.setWritable(false);
        File writeableFile = new File("writeable_file");
        writeableFile.setWritable(true);
        writeableFile.deleteOnExit();
        writeableFile.createNewFile();
    }

    @Test
    void validateFileDoesNotExist() {
        assertThrows(IllegalArgumentException.class, () -> OutputFileValidator.validateOutputFile(new File("does_not_exist")));
    }

    @Test
    void validateFileIsDirectory() {
        assertThrows(IllegalArgumentException.class, () -> OutputFileValidator.validateOutputFile(new File("src")));
    }

    @Test
    void validateFileIsNotWriteable() {
        assertThrows(IllegalArgumentException.class, () -> OutputFileValidator.validateOutputFile(new File("non_writeable_file")));
    }

    @Test
    void testValidFile() {
        assertDoesNotThrow(() -> OutputFileValidator.validateOutputFile(new File("writeable_file")));
    }

}