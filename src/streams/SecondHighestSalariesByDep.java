package streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import utils.Employee;

public class SecondHighestSalariesByDep {

    public static Map<String, Employee> secondHighestSalariesByDep(List<Employee> employees) {

        if (employees == null) {
            return Collections.emptyMap();
        }

        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.toList(), list -> list.stream()
                                        .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                                        .skip(1)
                                        .findFirst()
                                        .orElse(null))));
    }

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("1", "sanjay", "it", 250));
        employees.add(new Employee("2", "john", "hr", 200));
        employees.add(new Employee("3", "mary", "ops", 150));
        employees.add(new Employee("4", "princi", "it", 300));
        employees.add(new Employee("5", "asjd", "ops", 1000));

        Map<String, Employee> map = secondHighestSalariesByDep(employees);

        for (Entry<String, Employee> entry : map.entrySet()) {

            String empDetails = (entry.getValue() != null ? entry.getValue().toString() : "No employee found");
            System.out.println(entry.getKey() + " " + empDetails);
        }
    }

}
