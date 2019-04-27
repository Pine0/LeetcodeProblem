public class Leetcode_80 {
    /*
    80. Remove Duplicates from Sorted Array II  Medium

    Given a sorted array nums, remove the duplicates in-place such
    that duplicates appeared at most twice and return the new length.

    Do not allocate extra space for another array, you must do this
    by modifying the input array in-place with O(1) extra memory.

     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int times = 2, i = 0, j = 0;
        int cur = Integer.MIN_VALUE;
        while (j < nums.length) {
            if (nums[j] >= cur) {
                if (nums[j] > cur)
                    times = 2;
                if (times > 0) {
                    nums[i] = nums[j];
                    --times;
                    ++i;
                }
                cur = nums[j];
            }
            ++j;
        }
        return i;
    }
    public static void main(String[] args){
        int[] array = {1, 1, 1, 2, 3, 3, 3, 4, 5, 5, 7};
        System.out.println(removeDuplicates(array));
    }
}
