import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Top_NElements {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 1, 3, 5, 6, 6, 5, 3, 4);
        int N = 3;

        List<Integer> topNElements = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .limit(N)
                .toList();
        System.out.println(topNElements);
    }
}
