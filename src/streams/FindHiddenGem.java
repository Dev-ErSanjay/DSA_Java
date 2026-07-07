package streams;
// In this specific question, a "Hidden Gem" is defined by three strict conditions that an employee must meet simultaneously:

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

// Department Size: Their department must have more than 2 employees.
// Performance: Their performance score must be strictly higher than their department's average score.
// Salary: They must not be the highest-paid employee in that department.

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import utils.Employee;

public class FindHiddenGem {

    public static List<Employee> hiddenGem(List<Employee> employees) {

        if (employees == null)
            return null;

        // Pre calculated metrics
        Map<String, List<Employee>> map = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        map.entrySet().removeIf(entry -> entry.getValue().size() < 3);

        Map<String, Long> depCount = new HashMap<>();
        Map<String, Double> avgScore = new HashMap<>();
        Map<String, Double> maxScore = new HashMap<>();
        for (Entry<String, List<Employee>> entry : map.entrySet()) {

            depCount.put(entry.getKey(), (long) entry.getValue().size());
            avgScore.put(entry.getKey(),
                    entry.getValue().stream()
                            .mapToDouble(Employee::getScore)
                            .average()
                            .orElse(0.0));
            maxScore.put(entry.getKey(), entry.getValue().stream()
                    .map(Employee::getScore)
                    .sorted(Comparator.reverseOrder())
                    .findFirst()
                    .orElse(0.0));
        }

        return employees.stream()
                .filter(emp -> {
                    String department = emp.getDepartment();
                    Double avg = avgScore.getOrDefault(department, 0.0);
                    Double max = maxScore.getOrDefault(department, 0.0);

                    return emp.getScore() > avg && emp.getScore() < max;
                })
                .toList();
    }

    public static void main(String[] args) {

        List<Employee> sampleData = Arrays.asList(

                new Employee("E01", "Alice", "IT", 90.0, 150000),
                new Employee("E02", "Bob", "IT", 85.0, 110000),
                new Employee("E03", "Charlie", "IT", 60.0, 90000),
                new Employee("E04", "David", "HR", 95.0, 80000),
                new Employee("E05", "Eva", "HR", 70.0, 60000),
                new Employee("E06", "Frank", "Sales", 95.0, 130000),
                new Employee("E07", "Grace", "Sales", 40.0, 120000),
                new Employee("E08", "Henry", "Sales", 35.0, 110000) // Below average score -> Excluded (Rule 2)
        );

        List<Employee> result = hiddenGem(sampleData);

        if (result.isEmpty()) {
            System.out.println("No hidden gems found matching all criteria.");
        } else {
            result.forEach(System.out::println);
        }
    }
}