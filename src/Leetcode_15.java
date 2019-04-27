import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Leetcode_15 {
    /*
    15. 3Sum  Medium

    Given an array nums of n integers, are
    there elements a, b, c in nums such that
    a + b + c = 0? Find all unique triplets
    in the array which gives the sum of zero.

     */
    public static List threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List> li = new ArrayList<List>();
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            if (i != 0 && nums[i] == nums[i-1]) continue;
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] == 0) {
                    List<Integer> triplets = Arrays.asList(nums[i], nums[left], nums[right]);
                    li.add(triplets);
                    while (left < right && nums[left] == nums[left + 1])  left++;
                    while (left < right && nums[right] == nums[right - 1])right--;
                    left++;
                    right--;
                }
                else if (nums[left] + nums[right] + nums[i] > 0) {
                    while (left < right && nums[right] == nums[right - 1])right--;
                    right--;
                }
                else {
                    while (left < right && nums[left] == nums[left + 1])  left++;
                    left++;
                }
            }
        }
        return li;
    }
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-3, 0, 1, 2, 4}));
    }
}
