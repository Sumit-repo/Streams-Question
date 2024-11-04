import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CustomCollectors {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Doe");
        String s = names.stream().collect(joiningWithAnd());
        System.out.println(s);

        String result = names.stream()
                .limit(names.size() - 1) // Stream all but the last item
                .collect(Collectors.joining(", "))
                + " and " + names.get(names.size() - 1); // Add the last item with "and"

        System.out.println(result);
    }

    public static Collector<String, ? , String> joiningWithAnd(){
        return Collector.of(
                StringBuilder::new,
                (sb, s) -> {
                    if (!sb.isEmpty()) {
                        sb.append(", ");
                    }
                    sb.append(s);
                },
                (sb1, sb2) -> {
                    if (!sb1.isEmpty() && !sb2.isEmpty()) {
                        sb1.append(", ").append(sb2);
                    }
                    return sb1;
                },
                sb -> {
                    int lastComma = sb.lastIndexOf(", ");
                    if (lastComma != -1) {
                        sb.replace(lastComma, lastComma + 2, " and ");
                    }
                    return sb.toString();
                });
    }
}
