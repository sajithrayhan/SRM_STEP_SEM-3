package abstraction_interface.class_problems;

import java.util.Locale;
import java.util.Scanner;

public class TravelBookingWithCommonFee {

    static abstract class Booking {
        // The booking fee lives in exactly one place; change this line to change it everywhere.
        static final double BOOKING_FEE = 50;
        protected final double distanceKm;

        Booking(double distanceKm) {
            this.distanceKm = distanceKm;
        }

        abstract double baseFare();

        double total() {
            return baseFare() + BOOKING_FEE;
        }
    }

    static class BusBooking extends Booking {
        BusBooking(double km) { super(km); }
        double baseFare() { return 2 * distanceKm; }
    }

    static class TrainBooking extends Booking {
        TrainBooking(double km) { super(km); }
        double baseFare() { return 1.5 * distanceKm; }
    }

    static class FlightBooking extends Booking {
        FlightBooking(double km) { super(km); }
        double baseFare() { return 2500 + 4 * distanceKm; }
    }

    static Booking create(String mode, double km) {
        switch (mode) {
            case "BUS":    return new BusBooking(km);
            case "TRAIN":  return new TrainBooking(km);
            case "FLIGHT": return new FlightBooking(km);
            default: throw new IllegalArgumentException("Unknown mode: " + mode);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double total = create(mode, sc.nextDouble()).total();
            System.out.println(String.format(Locale.US, "%s: %.2f", mode, total));
        }
    }
}
