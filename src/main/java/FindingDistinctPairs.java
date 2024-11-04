import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindingDistinctPairs {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 5, 7, -1, 5);
        int targetSum = 6;

        Set<List<Integer>> distinctPairs = numbers.stream().flatMap(a -> numbers.stream()
                .skip(numbers.indexOf(a) + 1)
                .filter(b -> a + b == targetSum)
                .map(b-> Arrays.asList(a,b)))
                .collect(Collectors.toSet());

        System.out.println(distinctPairs);
    }
}
