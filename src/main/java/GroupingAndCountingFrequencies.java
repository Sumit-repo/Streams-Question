import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingAndCountingFrequencies {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "apricot", "blueberry");
        Map<Character,Long> map = words.stream()
                .collect(Collectors.groupingBy(e -> e.charAt(0),Collectors.counting()));

        System.out.println(map);
    }
}
