package streamsalgorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Employee {
    private String name;
    private int yearOfBirth;

    public Employee(String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John Doe",1980));
        employees.add(new Employee("Jane Doe",1990));
        employees.add(new Employee("Jack Doe",1970));
        employees.add(new Employee("Joe Doe",1969));

        System.out.println(employees.stream()
                .reduce(0, (i, e) -> i + e.getYearOfBirth(), (i1,i2)->i1+i2));

        int actualYear = 2022;
        System.out.println(
                employees.stream()
                        .reduce(0, (i, e) -> i + (actualYear - e.getYearOfBirth()), (i1,i2)->i1+i2)
        );

        System.out.println(
                employees.stream().count()
        );

        System.out.println(
                employees.stream()
                        .filter(e->e.getYearOfBirth()<1990)
                        .count()
        );

        Optional<Employee> earlyerBirth = employees.stream()
                .min(Comparator.comparingInt(Employee::getYearOfBirth));
        if (earlyerBirth.isPresent()) {
            System.out.println(earlyerBirth.get().getYearOfBirth());
        }

        Optional<Employee> earlyerBirthName = employees.stream()
                .filter(e->e.getYearOfBirth() == earlyerBirth.get().getYearOfBirth())
                .findFirst();
        if (earlyerBirthName.isPresent()) {
            System.out.println(earlyerBirthName.get().getName());
        }

        System.out.println(
                employees.stream()
                        .allMatch(e->e.getYearOfBirth()<1980)
        );

        List<Employee> olders = employees.stream()
                .filter(e->e.getYearOfBirth()<1980)
                .collect(Collectors.toList());

        System.out.println(olders);

        List<String> names = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println(names);

        List<String> oldersNames = employees.stream()
                .filter(e->e.getYearOfBirth()<1990)
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println(oldersNames);
    }
}
