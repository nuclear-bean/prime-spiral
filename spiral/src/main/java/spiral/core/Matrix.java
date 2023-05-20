package spiral.core;

import lombok.Getter;
import spiral.core.utils.ConsolePrinter;

public class Matrix {

    public final int size;

    @Getter
    protected final long[][] content;

    public Matrix(int size) {
        if (size % 2 == 0) throw new IllegalArgumentException("Only odd-side spirals are allowed");
        this.size = size;
        this.content = new long[size][size];
    }

    public void fillWith(long [][] matrix) {
        for (int i = 0; i < this.content.length; i++) {
            System.arraycopy(matrix[i], 0, this.content[i], 0, this.content[i].length);
        }
    }

    public void print() {
        ConsolePrinter.printSimple(this.content);
    }
}
