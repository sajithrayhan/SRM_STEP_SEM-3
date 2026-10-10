package inheritance_polymorphism.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class DeliveryFeeCalculator {

    static abstract class Delivery {
        protected final double weight, distance;

        Delivery(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }

        abstract String type();

        abstract double fee();
    }

    static class StandardDelivery extends Delivery {
        StandardDelivery(double w, double d) {
            super(w, d);
        }

        @Override
        String type() {
            return "STANDARD";
        }

        @Override
        double fee() {
            return 5 + 0.50 * weight + 0.10 * distance;
        }
    }

    static class ExpressDelivery extends Delivery {
        ExpressDelivery(double w, double d) {
            super(w, d);
        }

        @Override
        String type() {
            return "EXPRESS";
        }

        @Override
        double fee() {
            return 15 + 1.00 * weight + 0.20 * distance;
        }
    }

    static class InternationalDelivery extends Delivery {
        private final double customsFee;

        InternationalDelivery(double w, double d, double customsFee) {
            super(w, d);
            this.customsFee = customsFee;
        }


        @Override
        String type() {
            return "INTERNATIONAL";
        }

        @Override
        double fee() {
            return 25 + 2.00 * weight + 0.50 * distance + customsFee;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Delivery> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double w = sc.nextDouble();
            double d = sc.nextDouble();
            switch (type) {
                case "STANDARD":      list.add(new StandardDelivery(w, d)); break;
                case "EXPRESS":       list.add(new ExpressDelivery(w, d)); break;
                case "INTERNATIONAL": list.add(new InternationalDelivery(w, d, sc.nextDouble())); break;
                default: throw new IllegalArgumentException("Unknown delivery type: " + type);
            }
        }
        double total = 0;
        for (Delivery d : list) {
            double fee = d.fee();
            total += fee;
            System.out.println(String.format(Locale.US, "%s: %.2f", d.type(), fee));
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
