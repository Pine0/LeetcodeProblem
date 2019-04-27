import java.util.HashMap;
import java.util.Map;

public class Leetcode_220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length; i++) {
            Integer index = map.put(nums[i] , i);
            if (index != null)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
