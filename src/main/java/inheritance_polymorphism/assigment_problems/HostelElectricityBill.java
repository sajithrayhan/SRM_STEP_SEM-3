package inheritance_polymorphism.assigment_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class HostelElectricityBill {

    static abstract class Room {
        protected final double units;

        Room(double units) {
            this.units = units;
        }

        abstract String type();

        abstract double bill();
    }

    static class SingleRoom extends Room {
        SingleRoom(double units) {
            super(units);
        }

        @Override
        String type() {
            return "SINGLE";
        }

        @Override
        double bill() {
            return 8 * units;
        }
    }

    static class SharedRoom extends Room {
        // The extra value lives inside the object, so the main loop treats every room alike.
        private final int occupants;

        SharedRoom(double units, int occupants) {
            super(units);
            this.occupants = occupants;
        }


        @Override
        String type() {
            return "SHARED";
        }

        @Override
        double bill() {
            return 6 * units / occupants;
        }
    }

    static class AcRoom extends Room {
        AcRoom(double units) {
            super(units);
        }

        @Override
        String type() {
            return "AC";
        }

        @Override
        double bill() {
            return 10 * units + 200;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();
            switch (type) {
                case "SINGLE": rooms.add(new SingleRoom(units)); break;
                case "SHARED": rooms.add(new SharedRoom(units, sc.nextInt())); break;
                case "AC":     rooms.add(new AcRoom(units)); break;
                default: throw new IllegalArgumentException("Unknown room type: " + type);
            }
        }
        double total = 0;
        for (Room r : rooms) {
            double b = r.bill();
            total += b;
            System.out.println(String.format(Locale.US, "%s: %.2f", r.type(), b));
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
