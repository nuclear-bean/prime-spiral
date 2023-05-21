package spirals.ulam.translators.density;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DensityTranslationSpec {
    private boolean[][] matrix;

    @Builder.Default
    private boolean topLeft = true;
    @Builder.Default
    private boolean top = true;
    @Builder.Default
    private boolean topRight = true;
    @Builder.Default
    private boolean left = true;
    @Builder.Default
    private boolean self = true;
    @Builder.Default
    private boolean right = true;
    @Builder.Default
    private boolean bottomLeft = true;
    @Builder.Default
    private boolean bottom = true;
    @Builder.Default
    private boolean bottomRight = true;

    public void setDiagonals(boolean value) {
        topLeft = value;
        topRight = value;
        bottomLeft = value;
        bottomRight = value;
    }

    public void setAll(boolean value) {
        topLeft = value;
        top = value;
        topRight = value;
        left = value;
        self = value;
        right = value;
        bottomLeft = value;
        bottom = value;
        bottomRight = value;
    }

}
