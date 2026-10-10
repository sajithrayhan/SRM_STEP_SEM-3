package data_structures.class_problems;

import java.util.Scanner;

/**
 * Problem 1: Vowel and Consonant Counter.
 * Reads words and prints how many vowels and consonants each word contains.
 */
public class VowelAndConsonantCounter {

    private static final String VOWELS = "aeiou";

    /** Returns {vowels, consonants} for an alphabetic word (case-insensitive). */
    static int[] countVowelsAndConsonants(String word) {
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < word.length(); i++) {
            char letter = Character.toLowerCase(word.charAt(i));
            if (VOWELS.indexOf(letter) >= 0) {
                vowels++;
            } else {
                consonants++;
            }
        }
        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int[] counts = countVowelsAndConsonants(scanner.next());
            System.out.println("Vowels: " + counts[0]);
            System.out.println("Consonants: " + counts[1]);
        }
    }
}
