package abstraction_interface.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

public class HomeApplianceEnergyReport {

    // Optional capability: only some appliances have a saver mode.
    interface SaverMode {
        double SAVER_REDUCTION = 0.25;
    }

    static abstract class Appliance {
        static final double RATE_PER_UNIT = 8;
        private final double hours;

        Appliance(double hours) {
            this.hours = hours;
        }

        abstract double watts();

        double units(boolean saver) {
            double units = watts() * hours / 1000.0;
            if (saver) {
                units = units * (1 - SaverMode.SAVER_REDUCTION);
            }
            return units;
        }
    }

    static class Fridge extends Appliance {
        Fridge(double h) {
            super(h);
        }

        @Override
        double watts() {
            return 150;
        }
    }

    static class AirConditioner extends Appliance implements SaverMode {
        AirConditioner(double h) {
            super(h);
        }

        @Override
        double watts() {
            return 1500;
        }
    }

    static class Tv extends Appliance {
        Tv(double h) {
            super(h);
        }

        @Override
        double watts() {
            return 100;
        }
    }

    static class WashingMachine extends Appliance implements SaverMode {
        WashingMachine(double h) {
            super(h);
        }

        @Override
        double watts() {
            return 500;
        }
    }

    static Appliance create(String type, double hours) {
        switch (type) {
            case "FRIDGE": return new Fridge(hours);
            case "AC":     return new AirConditioner(hours);
            case "TV":     return new Tv(hours);
            case "WASHER": return new WashingMachine(hours);
            default: throw new IllegalArgumentException("Unknown appliance: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean saver = parts.length > 2 && parts[2].equals("SAVER");
            Appliance a = create(type, hours);
            if (saver && !(a instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }
            double units = a.units(saver);
            double cost = units * Appliance.RATE_PER_UNIT;
            total += cost;
            System.out.println(String.format(Locale.US, "%s: Units=%.2f Cost=%.2f", type, units, cost));
        }
        System.out.println(String.format(Locale.US, "Total Cost: %.2f", total));
    }
}
