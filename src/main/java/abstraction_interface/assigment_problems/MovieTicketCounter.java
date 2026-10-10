package abstraction_interface.assigment_problems;

import java.util.Locale;
import java.util.Scanner;

public class MovieTicketCounter {

    static abstract class Ticket {
        // Convenience fee is written in exactly one place.
        static final double CONVENIENCE_FEE = 20;
        private final int count;

        Ticket(int count) {
            this.count = count;
        }

        abstract double price();

        double amount() {
            return count * (price() + CONVENIENCE_FEE);
        }
    }

    static class RegularTicket extends Ticket {
        RegularTicket(int count) { super(count); }
        double price() { return 150; }
    }

    static class PremiumTicket extends Ticket {
        PremiumTicket(int count) { super(count); }
        double price() { return 250; }
    }

    static class ReclinerTicket extends Ticket {
        ReclinerTicket(int count) { super(count); }
        double price() { return 400; }
    }

    static Ticket create(String seat, int count) {
        switch (seat) {
            case "REGULAR":  return new RegularTicket(count);
            case "PREMIUM":  return new PremiumTicket(count);
            case "RECLINER": return new ReclinerTicket(count);
            default: throw new IllegalArgumentException("Unknown seat type: " + seat);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();
            double amount = create(seat, count).amount();
            total += amount;
            System.out.println(String.format(Locale.US, "%s: %.2f", seat, amount));
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
