package spiral;

import lombok.Getter;

public class Matrix {

    public final int size;

    @Getter
    private final long[][] content;

    public Matrix(int size) {
        if (size % 2 == 0) throw new IllegalArgumentException("Only odd-side spirals are allowed");
        this.size = size;
        this.content = new long[size][size];
    }

    //todo unit test this
    public long getPoint(int x, int y) {
        return content[(size/2) + x][(size/2) + y];
    }

    //todo unit test this
    public void fillWith(long [][] matrix) {
        for (int i = 0; i < this.content.length; i++) {
            System.arraycopy(matrix[i], 0, this.content[i], 0, this.content[i].length);
        }
    }

    public void print() {
        for (long[] points : content) {
            for (long point : points) {
                System.out.print(String.valueOf(point) + '\t');
            }
            System.out.println();
        }
    }
}
