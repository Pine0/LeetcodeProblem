import java.util.HashMap;
import java.util.Map;

public class Leetcode_219 {
    /*
    219. Contains Duplicate II  Easy

    Given an array of integers and an integer k,
    find out whether there are two distinct indices
    i and j in the array such that nums[i] = nums[j]
    and the absolute difference between i and j is
    at most k.

     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length < 2) return false;
        Map<Integer, Integer> map = new HashMap<>();
        if (nums.length > k) {
            for (int j = 0; j <= k; j++) {
                if (!map.containsKey(nums[j])) {
                    map.put(nums[j], 1);
                } else return true;
            }
            for (int i = 1; i < nums.length - k; i++) {
                map.remove(nums[i - 1]);
                if (!map.containsKey(nums[i + k])) {
                    map.put(nums[i + k], 1);
                } else return true;
            }
        }
        else {
            for (int j = 0; j < nums.length; j++) {
                if (!map.containsKey(nums[j])) {
                    map.put(nums[j], 1);
                } else return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(containsNearbyDuplicate(nums, 15));
    }

}
