package set3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortObjects {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Ravi M-2", "IT-2"));
        employees.add(new Employee(1, "Ravi M-1", "IT-1"));
        employees.add(new Employee(2, "Ravi M", "IT"));
        employees.add(new Employee(3, "Ravi Manjanaik", "BT"));
        employees.add(new Employee(3, "Ravi Manjanaik", "AT"));
        employees.add(new Employee(4, "Ravi M", "AT"));

        Collections.sort(employees,
                Comparator.comparing(Employee::getId)
                        .thenComparing(Employee::getName)
                        .thenComparing(Employee::getDepartment)
                        .reversed());
        employees.forEach(System.out::println);

    }

}
