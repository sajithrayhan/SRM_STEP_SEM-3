package data_structures.class_problems;

import java.util.Scanner;

/**
 * Problem 6: Prime Number Checker.
 * Tests divisors from 2 up to the square root of the number.
 */
public class PrimeNumberChecker {

    static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int divisor = 2; (long) divisor * divisor <= number; divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            System.out.println(number + (isPrime(number) ? " is prime" : " is not prime"));
        }
    }
}
