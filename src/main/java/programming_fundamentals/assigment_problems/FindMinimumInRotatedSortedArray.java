package programming_fundamentals.assigment_problems;

public class FindMinimumInRotatedSortedArray {

    // Modified binary search: compare mid with the rightmost element.
    static int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;             // minimum is in the right half
            } else {
                hi = mid;                 // minimum is mid or in the left half
            }
        }
        return nums[lo];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));         // 1
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));   // 0
        System.out.println(findMin(new int[]{11, 13, 15, 17}));        // 11
    }
}
