package data_structures.class_problems;

import java.util.Scanner;

/**
 * Problem 2: Word Reverser and Palindrome Checker.
 * Reverses each word with a StringBuilder and reports whether the original is a palindrome.
 */
public class WordReverserAndPalindromeChecker {

    static String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }

    static String describe(String word) {
        String reversed = reverse(word);
        String verdict = word.equals(reversed) ? "palindrome" : "not a palindrome";
        return reversed + " - " + verdict;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(describe(scanner.next()));
        }
    }
}
