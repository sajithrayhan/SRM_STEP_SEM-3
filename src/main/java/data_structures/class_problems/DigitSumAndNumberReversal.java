package data_structures.class_problems;

import java.util.Scanner;

/**
 * Problem 5: Digit Sum and Number Reversal.
 * Uses % 10 and / 10 to extract digits one at a time.
 */
public class DigitSumAndNumberReversal {

    static int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    static int reverseNumber(int number) {
        int reversed = 0;
        while (number > 0) {
            reversed = reversed * 10 + number % 10;
            number /= 10;
        }
        return reversed;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            System.out.println("Sum of digits: " + sumOfDigits(number));
            System.out.println("Reverse: " + reverseNumber(number));
        }
    }
}
