package data_structures.assigment_problems;

import java.util.Arrays;

/**
 * Problem 8: Duty Roster Rotation.
 *
 * <p>Rotates a roster to the right by k places. Full turns are removed with k % n, and the name at
 * index i moves to index (i + k) % n.
 *
 * <p>Complexity: time O(n) and additional space O(n) for the rotated copy, independent of k.
 *
 * <p>Why rotating one place at a time, k times, is slow: each single rotation touches all n names,
 * so the total work is O(n * k). With k up to 10^9 that is far too many steps, while k % n reduces
 * the whole job to one pass.
 */
public class DutyRosterRotation {

    static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        String[] rotated = new String[n];
        int shift = (int) (k % n);
        for (int i = 0; i < n; i++) {
            rotated[(i + shift) % n] = names[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};
        System.out.println(Arrays.toString(rotateRoster(names, 2)));   // [D, E, A, B, C]
        System.out.println(Arrays.toString(rotateRoster(names, 7)));   // [D, E, A, B, C]
    }
}
