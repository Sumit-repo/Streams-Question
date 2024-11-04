package Employee;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmployeeStreamSolution {
    public static void main(String[] args) {
        List<Employee> employeeList = Employees.employeeList();

        Map<String, Long> maleAndFemaleEmployeeCount = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::gender, Collectors.counting()));

        employeeList.stream()
                .map(Employee::department)
                .distinct()
                .forEach(System.out::println);

        Map<String, Double> avgAgeOfMaleAndFemaleEmp = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::gender, Collectors.averagingInt(Employee::age)));

        Employee highestPaidEmp = employeeList.stream()
                .max(Comparator.comparingDouble(Employee::salary))
                .get();

        List<String> empJoinedAfter2015 = employeeList.stream()
                .filter(employee -> employee.yearOfJoining() > 2015)
                .map(Employee::name)
                .toList();

        Map<String, Long> countOfEmpInEachDept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::department, Collectors.counting()));

        Map<String, Double> avgSalaryOfEachDept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::department, Collectors.averagingDouble(Employee::salary)));

        Employee youngestMaleEmpInProductDevelopmentDept = employeeList.stream()
                .filter(e -> e.gender().equals("Male"))
                .filter(e -> e.department().equals("Product Development"))
                .min(Comparator.comparingInt(Employee::age))
                .get();

        Employee mostExperiencedEmp = employeeList.stream()
                .min(Comparator.comparingInt(Employee::yearOfJoining))
                .get();

        Map<String, Long> maleAndFemaleEmpInSaleAndMarketingTeam = employeeList.stream()
                .filter(employee -> employee.department().equals("Sales And Marketing"))
                .collect(Collectors.groupingBy(Employee::gender, Collectors.counting()));

        Map<String, Double> avgSalaryOfMaleAndFemaleEmp = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::gender, Collectors.averagingDouble(Employee::salary)));

        Map<String, List<String>> EmpNameDeptWise = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::department, Collectors.mapping(Employee::name, Collectors.toList())));

        DoubleSummaryStatistics doubleSummaryStatistics = employeeList.stream()
                .collect(Collectors.summarizingDouble(Employee::salary));
        Double avgSalary = doubleSummaryStatistics.getAverage();
        Double totalSalary = doubleSummaryStatistics.getSum();

        Map<Boolean, List<Employee>> empOlderThan25AndYoungerThan25 = employeeList.stream()
                .collect(Collectors.partitioningBy(e -> e.age() > 25));

        Employee oldestEmployee = employeeList.stream().max(Comparator.comparingInt(Employee::age)).get();

    }
}
