package abstraction_interface.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

public class CityCabFareMeter {

    // Optional capability: only some cabs offer night service.
    interface NightService {
        double NIGHT_SURCHARGE = 0.20;
    }

    static abstract class Cab {
        // Minimum fare rule is shared by every cab.
        static final double MINIMUM_FARE = 100;
        private final double km;

        Cab(double km) {
            this.km = km;
        }

        abstract double ratePerKm();

        double dayFare() {
            return Math.max(km * ratePerKm(), MINIMUM_FARE);
        }
    }

    static class Mini extends Cab {
        Mini(double km) {
            super(km);
        }

        @Override
        double ratePerKm() {
            return 10;
        }
    }

    static class Sedan extends Cab implements NightService {
        Sedan(double km) {
            super(km);
        }

        @Override
        double ratePerKm() {
            return 14;
        }
    }

    static class Suv extends Cab implements NightService {
        Suv(double km) {
            super(km);
        }

        @Override
        double ratePerKm() {
            return 18;
        }
    }

    static Cab create(String type, double km) {
        switch (type) {
            case "MINI":  return new Mini(km);
            case "SEDAN": return new Sedan(km);
            case "SUV":   return new Suv(km);
            default: throw new IllegalArgumentException("Unknown cab type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            boolean night = sc.next().equals("NIGHT");
            Cab cab = create(type, km);
            double fare = cab.dayFare();
            if (night) {
                if (cab instanceof NightService) {
                    fare = fare * (1 + NightService.NIGHT_SURCHARGE);
                } else {
                    System.out.println(type + ": night service not available");
                    continue;
                }
            }
            total += fare;
            System.out.println(String.format(Locale.US, "%s: %.2f", type, fare));
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
