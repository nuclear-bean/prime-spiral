package spiral;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Point {

    @Getter
    @Setter
    private Long value = 0L;

    public Point(Long value) {
        this.value = value;
    }

    public static Point CENTER() {
        return new Point(1L);
    }
}
