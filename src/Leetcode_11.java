import java.util.*;
public class Leetcode_11 {
    /*
    11. Container With Most Water  Medium


    Given n non-negative integers a1, a2, ..., an ,
    where each represents a point at coordinate
    (i, ai). n vertical lines are drawn such that
    the two endpoints of line i is at (i, ai) and
    (i, 0). Find two lines, which together with
    x-axis forms a container, such that the container
    contains the most water.

    Note: You may not slant the
    container and n is at least 2.

     */
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxValue = 0;
        while (left < right) {
            maxValue = Math.max(maxValue, (right - left) * Math.min(height[left], height[right]));
            if (height[left] > height[right])
                right--;
            else
                left++;
        }
        return maxValue;
    }
    public static void main(String[] args) {
        int[] hright = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(hright));
    }
}
