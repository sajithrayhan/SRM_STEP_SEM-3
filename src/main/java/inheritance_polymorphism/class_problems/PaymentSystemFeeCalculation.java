package inheritance_polymorphism.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class PaymentSystemFeeCalculation {

    static abstract class Payment {
        protected final double amount;

        Payment(double amount) {
            this.amount = amount;
        }

        abstract String type();

        abstract double finalAmount();
    }

    static class CardPayment extends Payment {
        CardPayment(double amount) { super(amount); }
        String type() { return "CARD"; }
        double finalAmount() { return amount * 1.02; }
    }

    static class WalletPayment extends Payment {
        WalletPayment(double amount) { super(amount); }
        String type() { return "WALLET"; }
        double finalAmount() { return amount * 1.01; }
    }

    static class BankTransferPayment extends Payment {
        BankTransferPayment(double amount) { super(amount); }
        String type() { return "BANKTRANSFER"; }
        double finalAmount() { return amount; }
    }

    static Payment create(String type, double amount) {
        switch (type) {
            case "CARD":         return new CardPayment(amount);
            case "WALLET":       return new WalletPayment(amount);
            case "BANKTRANSFER": return new BankTransferPayment(amount);
            default: throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Payment> payments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            payments.add(create(sc.next(), sc.nextDouble()));
        }
        double total = 0;
        for (Payment p : payments) {          // uniform processing, no type checks
            double amt = p.finalAmount();
            total += amt;
            System.out.println(String.format(Locale.US, "%s: %.2f", p.type(), amt));
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
