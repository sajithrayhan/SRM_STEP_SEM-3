package data_structures.assigment_problems;

/**
 * Problem 7: Second-Best Score.
 *
 * <p>Finds the second-highest distinct score without sorting. Two variables, highest and second,
 * are updated while every score is visited once; a score equal to the current highest is skipped,
 * so duplicates of the top score never count as the second-best score.
 *
 * <p>Complexity: time O(n) and additional space O(1).
 *
 * <p>Comparison with sorting first: sorting costs O(n log n) time, and the duplicates of the top
 * score still have to be skipped afterwards to reach the second distinct value. The single pass is
 * faster for large arrays, needs no extra memory and does not modify the input.
 */
public class SecondBestScore {

    private static final int NOT_FOUND = -1;

    /** Returns the second-highest distinct score, or -1 if it does not exist. */
    static int secondHighest(int[] scores) {
        int highest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int score : scores) {
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score < highest && score > second) {
                second = score;
            }
        }
        return second == Integer.MIN_VALUE ? NOT_FOUND : second;
    }

    public static void main(String[] args) {
        System.out.println(secondHighest(new int[]{45, 78, 92, 78, 60}));   // 78
        System.out.println(secondHighest(new int[]{50, 50, 50}));           // -1
    }
}
