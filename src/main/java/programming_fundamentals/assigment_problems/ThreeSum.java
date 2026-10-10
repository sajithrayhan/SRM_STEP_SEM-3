package programming_fundamentals.assigment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    static int[][] threeSum(int[] nums) {
        int[] a = nums.clone();
        Arrays.sort(a);
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < a.length - 2; i++) {
            if (a[i] > 0) {
                break;                                    // smallest value positive: no more zero sums
            }
            if (i > 0 && a[i] == a[i - 1]) {
                continue;                                 // skip duplicate first values
            }
            int lo = i + 1;
            int hi = a.length - 1;
            while (lo < hi) {
                int sum = a[i] + a[lo] + a[hi];
                if (sum == 0) {
                    result.add(new int[]{a[i], a[lo], a[hi]});
                    while (lo < hi && a[lo] == a[lo + 1]) lo++;   // skip duplicate second values
                    while (lo < hi && a[hi] == a[hi - 1]) hi--;   // skip duplicate third values
                    lo++;
                    hi--;
                } else if (sum < 0) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(threeSum(new int[]{-1, 0, 1, 2, -1, -4})));   // [[-1, -1, 2], [-1, 0, 1]]
        System.out.println(Arrays.deepToString(threeSum(new int[]{0, 0, 0})));               // [[0, 0, 0]]
    }
}
