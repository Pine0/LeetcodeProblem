import java.util.*;
public class Leetcode_167 {
    /*
    167. Two Sum II - Input array is sorted  Easy

    Given an array of integers that is already sorted
    in ascending order, find two numbers such that
    they add up to a specific target number.

    The function twoSum should return indices of the
    two numbers such that they add up to the target,
    where index1 must be less than index2.

     */

    //map解法，并没有用到题目里的有序的条件
//    public static int[] twoSum(int[] numbers, int target) {
//
//        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
//        for (int i = 0; i < numbers.length; i++) {
//            map.put(target - numbers[i],i);
//        }
//        for (int i = 0; i < numbers.length; i++) {
//
//            if (map.get(numbers[i]) != null) {
//                int[] array = {i, map.get(numbers[i])};
//                return  array;
//            }
//
//        }
//        return null;
//    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            }
            else if (numbers[left] + numbers[right] < target) {
                left++;
            }
            else{
                return new int[] {left, right};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        int target = 13;
        int[] indexs = twoSum(array, target);
        System.out.println(indexs.toString());
    }
}
