package string_fundamentals.assigment_problems;

public class TypingSpeedTestAccuracyChecker {

    static void checkTypingAccuracy(String original, String typed) {
        int total = original.length();
        int matched = 0;
        int firstMismatch = -1;
        for (int i = 0; i < total; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }
        double accuracy = matched * 100.0 / total;
        String line = "Matched: " + matched + "/" + total + " | Accuracy: " + String.format("%.2f", accuracy) + "%";
        if (firstMismatch == -1) {
            System.out.println(line + " | No Mismatches");
        } else {
            System.out.println(line + " | First Mismatch at position " + (firstMismatch + 1)
                    + " ('" + original.charAt(firstMismatch) + "' vs '" + typed.charAt(firstMismatch) + "')");
        }
    }

    public static void main(String[] args) {
        try {
            checkTypingAccuracy("hello world", "hello worlt");
            checkTypingAccuracy("coding", "coding");
        } catch (RuntimeException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}
