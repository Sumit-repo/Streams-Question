import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AverageWordLengthInEachSentence {
    public static void main(String[] args) {
        List<String> sentences = Arrays.asList("Stream API is powerful", "Java functional programming");
        List<Double> avgWordLength = sentences.stream()
                .map(s -> Arrays.stream(s.split(" "))
                        .filter(word -> !word.isEmpty()) // Filter out empty strings
                        .mapToInt(String::length)
                        .average()
                        .orElse(0.0))
                .toList();

        System.out.println(avgWordLength);
    }
}
