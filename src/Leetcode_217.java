import java.util.HashMap;
import java.util.Map;

public class Leetcode_217 {
    /*
    217. Contains Duplicate  Easy

    Given an array of integers, find
    if the array contains any duplicates.

    Your function should return true if any
    value appears at least twice in the array,
    and it should return false if every element
    is distinct.
     */
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length; i++) {
            Integer index = map.put(nums[i] , i);
            if (index != null)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(containsDuplicate(nums));

    }
}
