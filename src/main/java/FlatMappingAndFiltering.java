import java.util.Arrays;
import java.util.List;

public class FlatMappingAndFiltering {
    public static void main(String[] args) {
        List<String> sentences = Arrays.asList("Java streams are powerful", "Streams enable functional programming");
        List<String> distinctAndSizeGreaterThan4 = sentences.stream().flatMap(e -> Arrays.stream(e.split(" ")).map(String::toLowerCase).filter(s -> s.length() > 4)).distinct().toList();
        System.out.println(distinctAndSizeGreaterThan4);
    }
}
