package spiral.core;

import lombok.Getter;
import spiral.core.utils.Printer;

public class Matrix {

    public final int size;

    @Getter
    private final long[][] content;

    public Matrix(int size) {
        if (size % 2 == 0) throw new IllegalArgumentException("Only odd-side spirals are allowed");
        this.size = size;
        this.content = new long[size][size];
    }

    public short[][] translate() {
        throw new UnsupportedOperationException();  //todo
    }

    //todo unit test this
    public long getPoint(int x, int y) {
        return content[(size/2) + x][(size/2) + y];
    }

    public void fillWith(long [][] matrix) {
        for (int i = 0; i < this.content.length; i++) {
            System.arraycopy(matrix[i], 0, this.content[i], 0, this.content[i].length);
        }
    }

    public void print() {
        Printer.printSimple(this.content);
    }
}
