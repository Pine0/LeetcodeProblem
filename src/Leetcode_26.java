public class Leetcode_26 {
    /*
    26. Remove Duplicates from Sorted Array   Easy

    Given a sorted array nums, remove the duplicates in-place such
    that each element appear only once and return the new length.

    Do not allocate extra space for another array, you must do this
    by modifying the input array in-place with O(1) extra memory.

     */
    public static int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        if (nums.length == 0)
            return 0;
        int cur = nums[0] - 1;
        while (j < nums.length){

            if (nums[j] > cur) {
                nums[i] = nums[j];
                ++i;
            }
            cur = nums[j];
            ++j;

        }
        return  i;
    }
    public static void main(String[] args){
        int[] array = {1,2,3,3,3,4};
        System.out.println(removeDuplicates(array));
    }
}
