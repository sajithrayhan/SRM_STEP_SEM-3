package data_structures.class_problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem 4: In-Place Array Reversal.
 * Reverses the token numbers with two pointers and no second array.
 */
public class InPlaceArrayReversal {

    static int[] parseIntList(String line) {
        String cleaned = line.replace("[", "").replace("]", "").trim();
        if (cleaned.isEmpty()) {
            return new int[0];
        }
        String[] parts = cleaned.split("\\s*,\\s*");
        int[] numbers = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i].trim());
        }
        return numbers;
    }

    /** Swaps elements from both ends until the pointers meet. Modifies the original array. */
    static void reverseInPlace(int[] tokens) {
        int left = 0;
        int right = tokens.length - 1;
        while (left < right) {
            int temp = tokens[left];
            tokens[left] = tokens[right];
            tokens[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isBlank()) {
                continue;
            }
            int[] tokens = parseIntList(line);
            reverseInPlace(tokens);
            System.out.println(Arrays.toString(tokens));
        }
    }
}
