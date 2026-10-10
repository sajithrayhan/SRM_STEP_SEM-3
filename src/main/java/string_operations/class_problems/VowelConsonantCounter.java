package string_operations.class_problems;

public class VowelConsonantCounter {

    static void countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = Character.toLowerCase(text.charAt(i));
            if (ch == ' ') {
                continue;                                  // ignore spaces
            }
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
            } else {
                consonants++;
            }
        }
        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }

    public static void main(String[] args) {
        try {
            countVowelsAndConsonants("Java Programming");      // Vowels: 5 | Consonants: 10
        } catch (RuntimeException exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}
