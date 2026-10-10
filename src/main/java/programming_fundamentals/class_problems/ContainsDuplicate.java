package programming_fundamentals.class_problems;

public class ContainsDuplicate {

    static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;      // early exit
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 1}));   // true
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4}));   // false
    }
}
