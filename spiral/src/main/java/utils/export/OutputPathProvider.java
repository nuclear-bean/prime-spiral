package utils.export;

import lombok.NonNull;

import java.io.File;

public final class OutputPathProvider {

    /**
     * Resolves the output path for given parameters and ensures that the path exists and is writable.
     */
    public static String prepareOutputPath(@NonNull final String name, int size, @NonNull final String extension, @NonNull final Class<?> clazz) {
        validateExtension(extension);
        String classPrefix = resolveClassPrefix(clazz);
        String path = constructPath(classPrefix, name, size, extension);
        createFiles(path);
        return path;
    }

    private static void validateExtension(String extension) {
        if (!extension.startsWith(".")) {
            throw new IllegalArgumentException("Extension must start with a dot");
        }
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private static void createFiles(String path) {
        File file = new File(path);
        file.getParentFile().mkdirs();
    }

    private static String constructPath(String classPrefix, String name, int size, String extension) {
        return "./output/" + classPrefix + '/' + size + '_' + name + extension;
    }

    private static String resolveClassPrefix(Class<?> clazz) {
        String name = clazz.getSimpleName();
        if (name.contains("_")) {
            return name.split("_")[0];
        }
        throw new IllegalArgumentException("Class name must contain underscore");
    }
}
