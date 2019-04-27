import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_16 {
    /*
    16. 3Sum Closest  Medium

    Given an array nums of n integers and
    an integer target, find three integers
    in nums such that the sum is closest to
    target. Return the sum of the three
    integers. You may assume that each
    input would have exactly one solution.
     */
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        List<List> li = new ArrayList<List>();
        int closest = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            if (i != 0 && nums[i] == nums[i-1]) continue;
            while (left < right) {
                int temp = nums[left] + nums[right] + nums[i] - target;
                if (temp == 0) {
                   return target;
                }
                else if (temp> 0) {
                    if (Math.abs(closest) > temp)
                        closest = nums[left] + nums[right] + nums[i] -target;
                    while (left < right && nums[right] == nums[right - 1])right--;
                    right--;
                }
                else {
                    if (Math.abs(closest) > Math.abs(temp))
                        closest = nums[left] + nums[right] + nums[i] -target;
                    while (left < right && nums[left] == nums[left + 1])  left++;
                    left++;
                }
            }
        }
        return target + closest;
    }
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[] {1,2,5,10,11},12));
    }
}
