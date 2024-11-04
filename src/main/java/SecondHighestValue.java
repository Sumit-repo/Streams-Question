import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SecondHighestValue {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 8, 15, 16, 23, 42, 8, 16, 23);

        Integer secondHighestValue = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();

        System.out.println(secondHighestValue);
    }
}
