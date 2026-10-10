package programming_fundamentals.assigment_problems;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    // Two passes, no division: left products going forward, right products going backward.
    static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        int left = 1;
        for (int i = 0; i < n; i++) {
            answer[i] = left;             // product of everything to the left of i
            left *= nums[i];
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= right;           // multiply in the product of everything to the right
            right *= nums[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));       // [24, 12, 8, 6]
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, 1, 0, -3, 3})));  // [0, 0, 9, 0, 0]
    }
}
