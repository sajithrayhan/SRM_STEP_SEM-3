package programming_fundamentals.assigment_problems;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    // prefix[j] - prefix[i] == k  <=>  an earlier prefix equals (currentSum - k).
    // Sliding window fails here because negative numbers break the "grow/shrink" monotonicity.
    static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);            // the empty prefix
        int sum = 0;
        int count = 0;
        for (int n : nums) {
            sum += n;
            count += prefixCount.getOrDefault(sum - k, 0);
            prefixCount.merge(sum, 1, Integer::sum);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));    // 2
        System.out.println(subarraySum(new int[]{1, -1, 0}, 0));   // 3
    }
}
