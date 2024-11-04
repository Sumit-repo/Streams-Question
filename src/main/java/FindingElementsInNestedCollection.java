import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class FindingElementsInNestedCollection {
    public static void main(String[] args) {
        List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 3, 5), Arrays.asList(2, 4, 8), Arrays.asList(7, 0));

        Integer maxElement = listOfLists.stream().flatMap(Collection::stream).max(Integer::compareTo).get();
        System.out.println(maxElement);
    }
}