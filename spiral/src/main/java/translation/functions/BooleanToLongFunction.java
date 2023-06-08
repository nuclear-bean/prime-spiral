package translation.functions;

@FunctionalInterface
public interface BooleanToLongFunction {
    long apply(boolean[][] matrix, int i, int j);
}
