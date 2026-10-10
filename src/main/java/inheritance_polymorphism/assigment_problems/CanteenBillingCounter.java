package inheritance_polymorphism.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CanteenBillingCounter {

    static abstract class Customer {
        protected final double bill;

        Customer(double bill) {
            this.bill = bill;
        }

        abstract String type();

        abstract double finalAmount();
    }

    static class Student extends Customer {
        Student(double bill) { super(bill); }
        String type() { return "STUDENT"; }
        double finalAmount() { return bill * 0.90; }
    }

    static class Staff extends Customer {
        Staff(double bill) { super(bill); }
        String type() { return "STAFF"; }
        double finalAmount() { return bill * 0.95; }
    }

    static class Guest extends Customer {
        Guest(double bill) { super(bill); }
        String type() { return "GUEST"; }
        double finalAmount() { return bill + 10; }
    }

    static Customer create(String type, double bill) {
        switch (type) {
            case "STUDENT": return new Student(bill);
            case "STAFF":   return new Staff(bill);
            case "GUEST":   return new Guest(bill);
            default: throw new IllegalArgumentException("Unknown customer type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            customers.add(create(sc.next(), sc.nextDouble()));
        }
        double total = 0;
        for (Customer c : customers) {
            double amt = c.finalAmount();
            total += amt;
            System.out.println(String.format(Locale.US, "%s: %.2f", c.type(), amt));
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
