package spirals.ulam.translators.density;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;

/**
 * Defines how density matrix should be calculated.
 */
@Builder(toBuilder = true)
@Getter
public class DensitySpecification {

    boolean [][] matrix;

    @Default
    int radius = 1;

    @Default
    int primeBias = 0;

}
