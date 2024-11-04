import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FilteringBasedOnConditionsMultipleStreams {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 1),
                new Employee("Bob", 2),
                new Employee("Charlie", null), // No department assigned
                new Employee("Dave", 3)
        );

        List<Department> departments = Arrays.asList(
                new Department(1, "HR"),
                new Department(3, "Engineering")
        );

        Set<Integer> deptIds = departments.stream().map(Department::deptId).collect(Collectors.toSet());

        List<String> employeeListWhoDoesNotBelongToAnyDept = employees.stream().filter(e -> !deptIds.contains(e.deptId())).map(Employee::name).toList();
        System.out.println(employeeListWhoDoesNotBelongToAnyDept);
    }
}

record Employee(String name, Integer deptId) {
}

record Department(Integer deptId, String deptName) {
}