package spirals.ulam.translators.density;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DensityTranslatorTest {

    @Test
    void testTranslation_1() {
        boolean[][] input = {
                {false, false, false},
                {false, false, false},
                {false, false, false}
        };
        short[][] expected = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        DensitySpecification specification = DensitySpecification.builder().matrix(input).build();
        short[][] actual = DensityTranslator.translate(specification);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testTranslation_2() {
        boolean[][] input = {
                {false, false, false},
                {false, true, false},
                {false, false, false}
        };
        short[][] expected =
                {{1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1}};
        DensitySpecification specification = DensitySpecification.builder().matrix(input).build();
        short[][] actual = DensityTranslator.translate(specification);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testTranslation_3() {
        boolean[][] input = {
                {false, false, false},
                {false, false, false},
                {false, false, true}
        };
        short[][] expected = {
                {0, 0, 0},
                {0, 1, 1},
                {0, 1, 1}};
        DensitySpecification specification = DensitySpecification.builder().matrix(input).build();
        short[][] actual = DensityTranslator.translate(specification);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testTranslation_4() {
        boolean[][] input = {
                {false, false, false},
                {false, false, false},
                {false, false, true}
        };
        short[][] expected = {
                {0, 0, 0},
                {0, 1, 1},
                {0, 1, 2}};
        DensitySpecification specification = DensitySpecification.builder().matrix(input).primeBias(1).build();
        short[][] actual = DensityTranslator.translate(specification);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testTranslation_5() {
        boolean[][] input = {
                {false, false, false},
                {false, false, false},
                {false, false, true}
        };
        short[][] expected = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 2}};
        DensitySpecification specification = DensitySpecification.builder()
                .matrix(input)
                .primeBias(1)
                .radius(2)
                .build();
        short[][] actual = DensityTranslator.translate(specification);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testTranslation_6() {
        boolean[][] input = {
                {false, false, false},
                {false, false, false},
                {false, false, true}
        };
        short[][] expected = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 4}};
        DensitySpecification specification = DensitySpecification.builder()
                .matrix(input)
                .primeBias(3)
                .radius(10)
                .build();
        short[][] actual = DensityTranslator.translate(specification);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testTranslation_7() {
        boolean[][] input = {
                {true, false, false},
                {false, false, false},
                {false, false, true}
        };
        short[][] expected = {
                {4, 1, 0},
                {1, 2, 1},
                {0, 1, 4}};
        DensitySpecification specification = DensitySpecification.builder()
                .matrix(input)
                .primeBias(3)
                .build();
        short[][] actual = DensityTranslator.translate(specification);
        assertArrayEquals(expected, actual);
    }

}