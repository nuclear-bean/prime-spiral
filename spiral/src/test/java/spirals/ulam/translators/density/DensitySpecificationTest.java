package spirals.ulam.translators.density;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DensitySpecificationTest {

    @Test
    void testDefaultValues() {
        // given
        DensitySpecification density = DensitySpecification.builder().build();

        // then
        assertNull(density.getMatrix());
        assertEquals(1, density.getRadius());
        assertEquals(1, density.getPrimeBias());
    }
}