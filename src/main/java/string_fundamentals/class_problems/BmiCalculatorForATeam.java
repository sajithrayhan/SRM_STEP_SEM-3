package string_fundamentals.class_problems;

public class BmiCalculatorForATeam {

    static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        }
        if (bmi < 25) {
            return "Normal";
        }
        if (bmi < 30) {
            return "Overweight";
        }
        return "Obese";
    }

    static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person | Height (m) | Weight (kg) | BMI | Status");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.println(String.format("%-6d | %-10.2f | %-11.1f | %.2f | %s",
                    i + 1, heights[i], weights[i], bmi, getBmiStatus(bmi)));
        }
    }

    public static void main(String[] args) {
        try {
            double[] heights = {1.75, 1.60, 1.82, 1.55, 1.68, 1.90, 1.72, 1.63, 1.78, 1.58};
            double[] weights = {70, 90, 64, 40, 75, 95, 82, 58, 110, 52};
            printWellnessReport(heights, weights);
        } catch (RuntimeException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}
