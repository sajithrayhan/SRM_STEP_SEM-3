package inheritance_polymorphism.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class FestivalBonusCalculator {

    static abstract class Employee {
        protected final String name;
        protected final double monthlySalary;

        Employee(String name, double monthlySalary) {
            this.name = name;
            this.monthlySalary = monthlySalary;
        }

        abstract double bonus();
    }

    static class FullTimeEmployee extends Employee {
        FullTimeEmployee(String n, double s) {
            super(n, s);
        }

        @Override
        double bonus() {
            return monthlySalary * 0.10;
        }
    }

    static class PartTimeEmployee extends Employee {
        PartTimeEmployee(String n, double s) {
            super(n, s);
        }

        @Override
        double bonus() {
            return monthlySalary * 0.05;
        }
    }

    static class InternEmployee extends Employee {
        InternEmployee(String n, double s) {
            super(n, s);
        }

        @Override
        double bonus() {
            return 2000;
        }
    }

    static Employee create(String type, String name, double salary) {
        switch (type) {
            case "FULLTIME": return new FullTimeEmployee(name, salary);
            case "PARTTIME": return new PartTimeEmployee(name, salary);
            case "INTERN":   return new InternEmployee(name, salary);
            default: throw new IllegalArgumentException("Unknown employee type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            employees.add(create(sc.next(), sc.next(), sc.nextDouble()));
        }
        double total = 0;
        for (Employee e : employees) {
            double b = e.bonus();
            total += b;
            System.out.println(String.format(Locale.US, "%s: %.2f", e.name, b));
        }
        System.out.println(String.format(Locale.US, "Total Bonus: %.2f", total));
    }
}
