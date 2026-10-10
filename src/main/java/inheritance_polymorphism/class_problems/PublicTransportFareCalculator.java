package inheritance_polymorphism.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class PublicTransportFareCalculator {

    static abstract class Journey {
        protected final double distance;

        Journey(double distance) {
            this.distance = distance;
        }

        abstract String type();

        abstract double fare();
    }

    static class BusJourney extends Journey {
        BusJourney(double d) {
            super(d);
        }

        @Override
        String type() {
            return "BUS";
        }

        @Override
        double fare() {
            return Math.min(2 + 0.10 * distance, 10);
        }
    }

    static class TrainJourney extends Journey {
        TrainJourney(double d) {
            super(d);
        }

        @Override
        String type() {
            return "TRAIN";
        }

        @Override
        double fare() {
            return 3 + 0.15 * distance;
        }
    }

    static class MetroJourney extends Journey {
        private final double peakHourFactor;

        MetroJourney(double d, double peakHourFactor) {
            super(d);
            this.peakHourFactor = peakHourFactor;
        }


        @Override
        String type() {
            return "METRO";
        }

        @Override
        double fare() {
            return (1.50 + 0.20 * distance) * peakHourFactor;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Journey> journeys = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double d = sc.nextDouble();
            switch (type) {
                case "BUS":   journeys.add(new BusJourney(d)); break;
                case "TRAIN": journeys.add(new TrainJourney(d)); break;
                case "METRO": journeys.add(new MetroJourney(d, sc.nextDouble())); break;
                default: throw new IllegalArgumentException("Unknown transport type: " + type);
            }
        }
        double total = 0;
        for (Journey j : journeys) {
            double fare = j.fare();
            total += fare;
            System.out.println(String.format(Locale.US, "%s: %.2f", j.type(), fare));
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
