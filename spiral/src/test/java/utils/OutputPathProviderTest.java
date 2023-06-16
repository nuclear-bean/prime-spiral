package utils;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import spirals.ulam.examples.basic.EB01_BasicUlam_png;
import spirals.ulam.examples.basic.EB01_BasicUlam_csv;
import utils.export.OutputPathProvider;

import java.io.File;

class OutputPathProviderTest {

    @Test
    void testThrowsAnExceptionWhenClassNameInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> OutputPathProvider.prepareOutputPath("basic_black_and_white", 10_001, ".png", OutputPathProviderTest.class));
    }

    @Test
    void testGetOutputPath_1() {
        String path = OutputPathProvider.prepareOutputPath("basic_black_and_white", 10_001, ".png", EB01_BasicUlam_png.class);
        Assertions.assertEquals("./output/EB01/10001_basic_black_and_white.png", path);
    }

    @Test
    void testGetOutputPath_2() {
        String path = OutputPathProvider.prepareOutputPath("basic_black_and_white", 501, ".png", EB01_BasicUlam_csv.class);
        Assertions.assertEquals("./output/EB01/501_basic_black_and_white.png", path);
    }

    @Test
    void shouldNotAcceptInvalidExtensionArg() {
        Throwable err = Assertions.assertThrows(IllegalArgumentException.class, () -> OutputPathProvider.prepareOutputPath("basic_black_and_white", 10_001, "png", EB01_BasicUlam_png.class));
        Assertions.assertEquals("Extension must start with a dot", err.getMessage());
    }

    @SuppressWarnings({"ResultOfMethodCallIgnored", "ConstantConditions"})
    @AfterAll
    static void tearDown() {
        File f = new File("./output");
        f.listFiles()[0].delete();
        f.delete();
    }

}