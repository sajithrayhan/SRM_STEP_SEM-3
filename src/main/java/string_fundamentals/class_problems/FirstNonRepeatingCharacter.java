package string_fundamentals.class_problems;

public class FirstNonRepeatingCharacter {

    // Returns the first character that occurs exactly once, or '\0' if there is none.
    static char findFirstNonRepeatingChar(String text) {
        int[] frequency = new int[65536];
        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }
        for (int i = 0; i < text.length(); i++) {
            if (frequency[text.charAt(i)] == 1) {
                return text.charAt(i);        // early exit
            }
        }
        return '\0';
    }

    static void report(String text) {
        char c = findFirstNonRepeatingChar(text);
        if (c == '\0') {
            System.out.println("No Non-Repeating Character Found");
        } else {
            System.out.println("First Non-Repeating Character: '" + c + "'");
        }
    }

    public static void main(String[] args) {
        report("swiss");
        report("aabbcc");
    }
}
