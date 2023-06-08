package translation.functions;

@FunctionalInterface
public interface MatrixMappingFunction {

    long mapPoint(long[][] matrix, int i, int j);
}
