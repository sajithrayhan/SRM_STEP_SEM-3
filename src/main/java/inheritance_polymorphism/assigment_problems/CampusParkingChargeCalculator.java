package inheritance_polymorphism.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class CampusParkingChargeCalculator {

    static abstract class Vehicle {
        protected final int hours;

        Vehicle(int hours) {
            this.hours = hours;
        }

        abstract String type();

        abstract double charge();
    }

    static class Bike extends Vehicle {
        Bike(int h) {
            super(h);
        }

        @Override
        String type() {
            return "BIKE";
        }

        @Override
        double charge() {
            return 10.0 * hours;
        }
    }

    static class Car extends Vehicle {
        Car(int h) {
            super(h);
        }

        @Override
        String type() {
            return "CAR";
        }

        @Override
        double charge() {
            return 30.0 + 20.0 * (hours - 1);
        }
    }

    static class Truck extends Vehicle {
        Truck(int h) {
            super(h);
        }

        @Override
        String type() {
            return "TRUCK";
        }

        @Override
        double charge() {
            return Math.max(50.0 * hours, 100.0);
        }
    }

    static Vehicle create(String type, int hours) {
        switch (type) {
            case "BIKE":  return new Bike(hours);
            case "CAR":   return new Car(hours);
            case "TRUCK": return new Truck(hours);
            default: throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            vehicles.add(create(sc.next(), sc.nextInt()));
        }
        double total = 0;
        for (Vehicle v : vehicles) {
            double c = v.charge();
            total += c;
            System.out.println(String.format(Locale.US, "%s: %.2f", v.type(), c));
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
