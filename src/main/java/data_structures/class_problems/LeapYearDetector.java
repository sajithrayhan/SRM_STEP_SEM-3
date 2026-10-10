package data_structures.class_problems;

import java.util.Scanner;

/**
 * Problem 9: Leap Year Detector.
 * A year is a leap year if it is divisible by 4, but not by 100, unless it is also divisible by 400.
 */
public class LeapYearDetector {

    static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            System.out.println(isLeapYear(scanner.nextInt()) ? "Leap year" : "Not a leap year");
        }
    }
}
