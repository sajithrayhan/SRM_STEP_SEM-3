package abstraction_interface.class_problems;

import java.util.Locale;
import java.util.Scanner;

public class WeeklyStaffPay {

    // Abstract: a generic staff member with no pay rule can never be created.
    static abstract class Staff {
        protected final String name;

        Staff(String name) {
            this.name = name;
        }

        abstract double pay();
    }

    static class FullTimeStaff extends Staff {
        private final double weeklySalary;

        FullTimeStaff(String name, double weeklySalary) {
            super(name);
            this.weeklySalary = weeklySalary;
        }


        @Override
        double pay() {
            return weeklySalary;
        }
    }

    static class HourlyStaff extends Staff {
        private final double hours, rate;

        HourlyStaff(String name, double hours, double rate) {
            super(name);
            this.hours = hours;
            this.rate = rate;
        }


        @Override
        double pay() {
            double regular = Math.min(hours, 40);
            double overtime = Math.max(hours - 40, 0);
            return regular * rate + overtime * rate * 1.5;
        }
    }

    static class Intern extends Staff {
        private final double stipend;

        Intern(String name, double stipend) {
            super(name);
            this.stipend = stipend;
        }


        @Override
        double pay() {
            return stipend;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Staff s;
            switch (type) {
                case "FULLTIME":
                    s = new FullTimeStaff(name, sc.nextDouble());
                    break;
                case "HOURLY":
                    s = new HourlyStaff(name, sc.nextDouble(), sc.nextDouble());
                    break;
                case "INTERN":
                    s = new Intern(name, sc.nextDouble());
                    break;
                default:
                    throw new IllegalArgumentException("Unknown staff type: " + type);
            }
            double pay = s.pay();
            total += pay;
            System.out.println(String.format(Locale.US, "%s: %.2f", s.name, pay));
        }
        System.out.println(String.format(Locale.US, "Total Payroll: %.2f", total));
    }
}
