package abstraction_interface.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

public class CollegeFeeCounter {

    // Optional capability: only some students use the college bus.
    interface BusUser {
        double TRANSPORT_FEE = 12000;
    }

    static abstract class Student {
        protected final String name;

        Student(String name) {
            this.name = name;
        }

        abstract double baseFee();

        double totalFee() {
            double fee = baseFee();
            if (this instanceof BusUser) {
                fee += BusUser.TRANSPORT_FEE;
            }
            return fee;
        }
    }

    static class DayScholar extends Student implements BusUser {
        DayScholar(String name) {
            super(name);
        }

        @Override
        double baseFee() {
            return 40000;
        }
    }

    static class Hosteller extends Student {
        Hosteller(String name) {
            super(name);
        }

        @Override
        double baseFee() {
            return 40000 + 60000;
        }
    }

    static class ScholarshipStudent extends Student implements BusUser {
        ScholarshipStudent(String name) {
            super(name);
        }

        @Override
        double baseFee() {
            return 20000;
        }
    }

    static Student create(String type, String name) {
        switch (type) {
            case "DAY_SCHOLAR": return new DayScholar(name);
            case "HOSTELLER":   return new Hosteller(name);
            case "SCHOLAR":     return new ScholarshipStudent(name);
            default: throw new IllegalArgumentException("Unknown student type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            Student s = create(sc.next(), sc.next());
            double fee = s.totalFee();
            total += fee;
            System.out.println(String.format(Locale.US, "%s: %.2f", s.name, fee));
        }
        System.out.println(String.format(Locale.US, "Total Collected: %.2f", total));
    }
}
