package arrays_methods.class_problems;

import java.util.Arrays;

public class HackathonScoreCurveBooster {

    // Arrays are passed by reference, so the caller's array is modified directly.
    static void curveScores(int[] scores, int bonus) {
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        int[] scores = {70, 85, 60};
        curveScores(scores, 10);
        System.out.println(Arrays.toString(scores));     // [80, 95, 70]
    }
}
