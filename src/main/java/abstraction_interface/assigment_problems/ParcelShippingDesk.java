package abstraction_interface.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

public class ParcelShippingDesk {

    // Optional capability: only some parcels can be insured.
    interface Insurable {
        double INSURANCE_RATE = 0.02;
        double insurance();
    }

    static abstract class Parcel {
        protected final double weightKg;
        protected final double declaredValue;

        Parcel(double weightKg, double declaredValue) {
            this.weightKg = weightKg;
            this.declaredValue = declaredValue;
        }

        abstract double charge();
    }

    static class StandardParcel extends Parcel {
        StandardParcel(double w, double v) { super(w, v); }
        double charge() { return 40 + 10 * weightKg; }
    }

    static class ExpressParcel extends Parcel implements Insurable {
        ExpressParcel(double w, double v) { super(w, v); }
        double charge() { return 80 + 15 * weightKg; }
        public double insurance() { return INSURANCE_RATE * declaredValue; }
    }

    static class FragileParcel extends Parcel implements Insurable {
        FragileParcel(double w, double v) { super(w, v); }
        double charge() { return 40 + 10 * weightKg + 50; }
        public double insurance() { return INSURANCE_RATE * declaredValue; }
    }

    static Parcel create(String type, double w, double v) {
        switch (type) {
            case "STANDARD": return new StandardParcel(w, v);
            case "EXPRESS":  return new ExpressParcel(w, v);
            case "FRAGILE":  return new FragileParcel(w, v);
            default: throw new IllegalArgumentException("Unknown parcel type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grand = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double w = sc.nextDouble();
            double v = sc.nextDouble();
            Parcel p = create(type, w, v);
            double charge = p.charge();
            double insurance = (p instanceof Insurable) ? ((Insurable) p).insurance() : 0;
            double total = charge + insurance;
            grand += total;
            System.out.println(String.format(Locale.US,
                    "%s: Charge=%.2f Insurance=%.2f Total=%.2f", type, charge, insurance, total));
        }
        System.out.println(String.format(Locale.US, "Grand Total: %.2f", grand));
    }
}
