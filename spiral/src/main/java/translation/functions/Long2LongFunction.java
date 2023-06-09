package translation.functions;

@FunctionalInterface
public interface Long2LongFunction {

    long mapPoint(long[][] matrix, int i, int j);
}
