package programming_fundamentals.class_problems;

import java.util.Arrays;

public class RotateArray {

    static int[] rotateArray(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return nums;
        }
        k = k % n;                        // rotating by a multiple of the length changes nothing
        int[] rotated = new int[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = nums[i];
        }
        for (int i = 0; i < n; i++) {     // copy back into the original as well
            nums[i] = rotated[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotateArray(new int[]{1, 2, 3, 4, 5, 6, 7}, 3)));  // [5, 6, 7, 1, 2, 3, 4]
        System.out.println(Arrays.toString(rotateArray(new int[]{1, 2}, 3)));                  // [2, 1]
    }
}
