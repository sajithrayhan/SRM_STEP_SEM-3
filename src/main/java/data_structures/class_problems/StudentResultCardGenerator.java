package data_structures.class_problems;

import java.util.Locale;
import java.util.Scanner;

/**
 * Problem 10: Student Result Card Generator.
 * Each student has a name and three marks; the average decides the grade.
 */
public class StudentResultCardGenerator {

    static class Student {
        private final String name;
        private final int[] marks;

        Student(String name, int[] marks) {
            this.name = name;
            this.marks = marks;
        }

        double average() {
            int total = 0;
            for (int mark : marks) {
                total += mark;
            }
            return (double) total / marks.length;
        }

        /** A: 90 or more, B: 75 or more, C: 60 or more, D: 40 to 59, F: below 40. */
        char grade() {
            double average = average();
            if (average >= 90) {
                return 'A';
            } else if (average >= 75) {
                return 'B';
            } else if (average >= 60) {
                return 'C';
            } else if (average >= 40) {
                return 'D';
            } else {
                return 'F';
            }
        }

        String resultCard() {
            return String.format(Locale.US, "%s: Average %.1f, Grade %c", name.toUpperCase(), average(), grade());
        }
    }

    /** Parses a line such as "Asha [80, 90, 70]". */
    static Student parseStudent(String line) {
        int bracket = line.indexOf('[');
        String name = line.substring(0, bracket).trim();
        String[] parts = line.substring(bracket + 1, line.indexOf(']')).split("\\s*,\\s*");
        int[] marks = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            marks[i] = Integer.parseInt(parts[i].trim());
        }
        return new Student(name, marks);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isBlank()) {
                continue;
            }
            System.out.println(parseStudent(line).resultCard());
        }
    }
}
