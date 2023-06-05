package utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import spirals.ulam.examples.E01_BasicBlackAndWhite;
import spirals.ulam.examples.E02_ExportToCSV;
import utils.export.OutputPathProvider;

class OutputPathProviderTest {

    @Test
    void testThrowsAnExceptionWhenClassNameInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> OutputPathProvider.getOutputPath("basic_black_and_white", 10_001, ".png", OutputPathProviderTest.class));
    }

    @Test
    void testGetOutputPath_1() {
        String path = OutputPathProvider.getOutputPath("basic_black_and_white", 10_001, ".png", E01_BasicBlackAndWhite.class);
        Assertions.assertEquals("./output/E01/10001_basic_black_and_white.png", path);
    }

    @Test
    void testGetOutputPath_2() {
        String path = OutputPathProvider.getOutputPath("basic_black_and_white", 501, ".png", E02_ExportToCSV.class);
        Assertions.assertEquals("./output/E02/501_basic_black_and_white.png", path);
    }

    @Test
    void shouldNotAcceptInvalidExtensionArg() {
        Throwable err = Assertions.assertThrows(IllegalArgumentException.class, () -> OutputPathProvider.getOutputPath("basic_black_and_white", 10_001, "png", E01_BasicBlackAndWhite.class));
        Assertions.assertEquals("Extension must start with a dot", err.getMessage());
    }

}