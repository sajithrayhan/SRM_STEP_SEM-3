package data_structures.assigment_problems;

/**
 * Problem 6: Class Attendance Tracker.
 *
 * <p>Counts the days a student was present and the longest unbroken run of present days. A running
 * streak grows on every 1 and resets to 0 on every 0; the largest value it reaches is remembered.
 *
 * <p>Complexity: time O(n) and additional space O(1), where n is the number of days. Both answers
 * are found together in a single pass over the array.
 */
public class ClassAttendanceTracker {

    /** Returns {presentDays, longestStreak}. */
    static int[] attendanceSummary(int[] days) {
        int present = 0;
        int currentStreak = 0;
        int longestStreak = 0;
        for (int day : days) {
            if (day == 1) {
                present++;
                currentStreak++;
                longestStreak = Math.max(longestStreak, currentStreak);
            } else {
                currentStreak = 0;
            }
        }
        return new int[]{present, longestStreak};
    }

    static void print(int[] days) {
        int[] summary = attendanceSummary(days);
        System.out.println("Present: " + summary[0] + ", Longest streak: " + summary[1]);
    }

    public static void main(String[] args) {
        print(new int[]{1, 1, 0, 1, 1, 1, 0, 1});
        print(new int[]{0, 0, 0});
    }
}
