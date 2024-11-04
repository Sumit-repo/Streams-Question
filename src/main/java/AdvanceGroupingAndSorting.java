import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdvanceGroupingAndSorting {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("Alice", 25), new Person("Bob", 25), new Person("Charlie", 30));

        Map<Integer, List<String>> groupedByAge = people.stream()
                .collect(Collectors.groupingBy(
                        Person::age,
                        Collectors.mapping(
                                Person::name,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        list -> list.stream()
                                                .sorted(Comparator.reverseOrder())
                                                .collect(Collectors.toList())
                                )
                        )
                ));
        System.out.println(groupedByAge);
    }
}

record Person(String name, int age) {
}
