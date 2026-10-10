package abstraction_interface.class_problems;

import java.util.Locale;
import java.util.Scanner;

public class ElectricityConnectionBilling {

    static abstract class Connection {
        protected final double units;

        Connection(double units) {
            this.units = units;
        }

        abstract double bill();
    }

    static class HomeConnection extends Connection {
        HomeConnection(double units) { super(units); }

        double bill() {
            double first = Math.min(units, 100);
            double rest = Math.max(units - 100, 0);
            return first * 5 + rest * 7;
        }
    }

    static class ShopConnection extends Connection {
        ShopConnection(double units) { super(units); }
        double bill() { return units * 8 + 100; }
    }

    static class FactoryConnection extends Connection {
        FactoryConnection(double units) { super(units); }
        double bill() { return Math.max(units * 6, 1000); }
    }

    static Connection create(String type, double units) {
        switch (type) {
            case "HOME":    return new HomeConnection(units);
            case "SHOP":    return new ShopConnection(units);
            case "FACTORY": return new FactoryConnection(units);
            default: throw new IllegalArgumentException("Unknown connection type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double bill = create(type, sc.nextDouble()).bill();
            total += bill;
            System.out.println(String.format(Locale.US, "%s: %.2f", type, bill));
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
