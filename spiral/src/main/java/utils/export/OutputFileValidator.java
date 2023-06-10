package utils.export;

import java.io.File;

public final class OutputFileValidator {

    public static void validateOutputFile(final File file) {
        checkIfFileExists(file);
        checkIfFileIsDirectory(file);
        checkIfFileIsWriteable(file);
    }

    private static void checkIfFileIsWriteable(File file) {
        if (!file.canWrite()) {
            throw new IllegalArgumentException("Output file is not writable: " + file.getAbsolutePath());
        }
    }

    private static void checkIfFileIsDirectory(File file) {
        if (file.isDirectory()) {
            throw new IllegalArgumentException("Output file is a directory: " + file.getAbsolutePath());
        }
    }

    private static void checkIfFileExists(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException("Output file does not exist: " + file.getAbsolutePath());
        }
    }

}
