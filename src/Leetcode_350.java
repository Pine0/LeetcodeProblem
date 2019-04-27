import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Leetcode_350 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> nums3= new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums2.length; i++) {
            if (!map.containsKey(nums2[i]))
                map.put(nums2[i], 1);
            else
                map.put(nums2[i], map.get(nums2[i]) + 1);
        }
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i]) && map.get(nums1[i]) > 0) {
                map.put(nums1[i], map.get(nums1[i]) - 1);
                nums3.add(nums1[i]);
            }
        }
        int[] res = new int[nums3.size()];
        for(int i = 0; i < nums3.size(); i++) {
            res[i] = nums3.get(i);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5 };
        int[] nums2 = {9, 4, 9, 8, 4 };
        int[] nums3 = intersect(nums1, nums2);
        for (int i = 0; i< nums3.length; i++) {
            System.out.print(nums3[i] + " ");
        }
    }
}
