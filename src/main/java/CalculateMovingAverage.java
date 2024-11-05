import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CalculateMovingAverage {
    public static void main(String[] args) {
        List<Double> values = Arrays.asList(10.0, 20.0, 30.0, 40.0, 50.0);
        int windowSize = 3;

        List<Double> movingAverages = IntStream.range(0, values.size() - windowSize + 1)
                .mapToObj(i -> values.subList(i, i + windowSize).stream()
                        .mapToDouble(Double::doubleValue)
                        .average()
                        .orElse(0.0))
                .toList();

        System.out.println(movingAverages);
    }
}
