package abstraction_interface.class_problems;

import java.util.Locale;
import java.util.Scanner;

public class GardenPlotAreaReport {

    static abstract class Plot {
        protected final String owner;

        Plot(String owner) {
            this.owner = owner;
        }

        abstract String shape();

        abstract double area();
    }

    static class CirclePlot extends Plot {
        private final double radius;

        CirclePlot(String owner, double radius) {
            super(owner);
            this.radius = radius;
        }


        @Override
        String shape() {
            return "CIRCLE";
        }

        @Override
        double area() {
            return Math.PI * radius * radius;
        }
    }

    static class RectanglePlot extends Plot {
        private final double length, width;

        RectanglePlot(String owner, double length, double width) {
            super(owner);
            this.length = length;
            this.width = width;
        }


        @Override
        String shape() {
            return "RECTANGLE";
        }

        @Override
        double area() {
            return length * width;
        }
    }

    static class TrianglePlot extends Plot {
        private final double base, height;

        TrianglePlot(String owner, double base, double height) {
            super(owner);
            this.base = base;
            this.height = height;
        }


        @Override
        String shape() {
            return "TRIANGLE";
        }

        @Override
        double area() {
            return 0.5 * base * height;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();
            Plot plot;
            switch (shape) {
                case "CIRCLE":
                    plot = new CirclePlot(owner, sc.nextDouble());
                    break;
                case "RECTANGLE":
                    plot = new RectanglePlot(owner, sc.nextDouble(), sc.nextDouble());
                    break;
                case "TRIANGLE":
                    plot = new TrianglePlot(owner, sc.nextDouble(), sc.nextDouble());
                    break;
                default:
                    throw new IllegalArgumentException("Unknown shape: " + shape);
            }
            double area = plot.area();
            total += area;
            System.out.println(String.format(Locale.US, "%s (%s): %.2f", plot.owner, plot.shape(), area));
        }
        System.out.println(String.format(Locale.US, "Total Area: %.2f", total));
    }
}
