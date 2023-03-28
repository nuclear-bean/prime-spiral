package spiral;

public class Matrix {

    final int size;
    final Point [][] content;

    public Matrix(int size) {
        //todo validate size - only odd numbers
        this.size = size;
        content = new Point[size][size];
        content[size/2][size/2] = new Point(0,0,1);
    }
}
