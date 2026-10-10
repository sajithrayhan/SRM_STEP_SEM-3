package data_structures.class_problems;

import java.util.Scanner;

/**
 * Problem 7: Factorial Calculation.
 * Multiplies 1 up to n; 0! is defined as 1 (the empty product).
 */
public class FactorialCalculation {

    static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            System.out.println(factorial(scanner.nextInt()));
        }
    }
}
