package spirals.ulam.translators.density;

import lombok.Builder;
import lombok.Getter;

/**
 * Defines how density matrix should be calculated.
 */
@Builder(toBuilder = true)
@Getter
public class DensitySpecification {

    boolean [][] matrix;

    @Builder.Default
    int radius = 1;

    @Builder.Default
    int primeBias = 0;

}
