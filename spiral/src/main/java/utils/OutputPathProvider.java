package utils;

import java.io.File;

public final class OutputPathProvider {

    public static String getOutputPath(String name, int size, String extension, Class<?> clazz) {
        String classPrefix = resolveClassPrefix(clazz);
        String path = constructPath(classPrefix, name, size, extension);
        createFiles(path);
        return path;
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
