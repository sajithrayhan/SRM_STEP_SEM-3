package data_structures.class_problems;

import java.util.Scanner;

/**
 * Problem 8: Student Grade Assignment.
 * A: 90 and above, B: 75 to 89, C: 60 to 74, D: 40 to 59, F: below 40.
 */
public class StudentGradeAssignment {

    static char gradeFor(int marks) {
        if (marks >= 90) {
            return 'A';
        } else if (marks >= 75) {
            return 'B';
        } else if (marks >= 60) {
            return 'C';
        } else if (marks >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            System.out.println("Grade " + gradeFor(scanner.nextInt()));
        }
    }
}
