package inheritance_polymorphism.assigment_problems;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StreamingPlanRenewalReminder {

    static abstract class Plan {
        protected final String name;
        protected final LocalDate startDate;

        Plan(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }

        abstract int validityDays();

        LocalDate renewalDate() {
            return startDate.plusDays(validityDays());
        }
    }

    static class BasicPlan extends Plan {
        BasicPlan(String n, LocalDate d) {
            super(n, d);
        }

        @Override
        int validityDays() {
            return 30;
        }
    }

    static class StandardPlan extends Plan {
        StandardPlan(String n, LocalDate d) {
            super(n, d);
        }

        @Override
        int validityDays() {
            return 90;
        }
    }

    static class PremiumPlan extends Plan {
        PremiumPlan(String n, LocalDate d) {
            super(n, d);
        }

        @Override
        int validityDays() {
            return 365;
        }
    }

    static Plan create(String type, String name, LocalDate start) {
        switch (type) {
            case "BASIC":    return new BasicPlan(name, start);
            case "STANDARD": return new StandardPlan(name, start);
            case "PREMIUM":  return new PremiumPlan(name, start);
            default: throw new IllegalArgumentException("Unknown plan type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Plan> plans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            plans.add(create(sc.next(), sc.next(), LocalDate.parse(sc.next())));
        }
        for (Plan p : plans) {
            System.out.println(p.name + ": " + p.renewalDate());
        }
    }
}
