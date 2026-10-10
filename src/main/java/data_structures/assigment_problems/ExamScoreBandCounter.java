package data_structures.assigment_problems;

/**
 * Problem 4: Exam Score Band Counter.
 *
 * <p>Counts the scores s with low <= s <= high in an ascending sorted array without scanning every
 * score. Two modified binary searches find the first position with a score >= low and the first
 * position with a score > high; the answer is the difference of those positions.
 *
 * <p>Complexity: a linear scan takes O(n) time and O(1) space. The binary-search solution takes
 * O(log n) time and O(1) space, which matters when the array is large and queried very often.
 *
 * <p>Duplicates at the edges: a standard binary search stops at any matching element, which could
 * be in the middle of a run of equal scores. The two searches here keep moving until they land on
 * the exact boundary (first element >= low, first element > high), so every duplicate inside the
 * band is counted and none outside it.
 */
public class ExamScoreBandCounter {

    /** Index of the first element >= target (scores.length if there is none). */
    static int firstAtLeast(int[] scores, int target) {
        int lo = 0;
        int hi = scores.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (scores[mid] >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    /** Index of the first element > target (scores.length if there is none). */
    static int firstGreaterThan(int[] scores, int target) {
        int lo = 0;
        int hi = scores.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (scores[mid] > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    static int countInBand(int[] scores, int low, int high) {
        return firstGreaterThan(scores, high) - firstAtLeast(scores, low);
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        System.out.println(countInBand(scores, 42, 58));    // 6
        System.out.println(countInBand(scores, 90, 100));   // 0
    }
}
