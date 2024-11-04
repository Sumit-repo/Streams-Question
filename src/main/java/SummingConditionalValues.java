import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SummingConditionalValues {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("A1", 500),
                new Transaction("A2", 1500),
                new Transaction("A1", 300),
                new Transaction("A3", 700),
                new Transaction("A2", 800),
                new Transaction("A3", 2000)
        );

        double limit = 1000;

        Map<String, Double> summary = transactions.stream().filter(t -> t.amount() <= limit).collect(Collectors.groupingBy(Transaction::accountId, Collectors.summingDouble(Transaction::amount)));
        System.out.println(summary);
    }
}

record Transaction(String accountId, double amount) {
}
