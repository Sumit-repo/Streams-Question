import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ZippingTwoListsTogether {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7);

        int maxPairs = Math.min(list1.size(), list2.size());

        List<List<Integer>> zippedList = IntStream.range(0,maxPairs)
                .mapToObj(i -> Arrays.asList(list1.get(i),list2.get(i)))
                .toList();

        System.out.println(zippedList);
    }
}
