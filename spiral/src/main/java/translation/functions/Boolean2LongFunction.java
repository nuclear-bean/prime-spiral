package translation.functions;

@FunctionalInterface
public interface Boolean2LongFunction {
    long apply(boolean[][] matrix, int i, int j);
}
