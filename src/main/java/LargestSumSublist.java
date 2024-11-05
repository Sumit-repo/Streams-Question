import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LargestSumSublist {
    public static void main(String[] args) {
        List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5), Arrays.asList(6, 7, 8));
        List<Integer> largestSumSubset = listOfLists.stream()
                .max(Comparator.comparingInt(l -> l.stream().mapToInt(Integer::intValue).sum()))
                .get();
        System.out.println(largestSumSubset);
    }
}
