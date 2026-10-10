package data_structures.class_problems;

import java.util.Scanner;

/**
 * Problem 3: Even and Odd Numbers in a List.
 * Counts the even and odd values of a list such as [3, 8, 12, 5, 7, 10].
 */
public class EvenAndOddNumbersInList {

    /** Parses a line such as "[3, 8, 12]" into an int array. */
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

    /** Returns {evenCount, oddCount}. */
    static int[] countEvenAndOdd(int[] numbers) {
        int even = 0;
        int odd = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return new int[]{even, odd};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isBlank()) {
                continue;
            }
            int[] counts = countEvenAndOdd(parseIntList(line));
            System.out.println("Even: " + counts[0]);
            System.out.println("Odd: " + counts[1]);
        }
    }
}
