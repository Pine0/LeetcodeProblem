import java.util.*;

public class Leetcode_49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
        for (int i = 0; i < strs.length; i++) {
            char[] item1 = strs[i].toCharArray();
            Arrays.sort(item1);
            String wordhash = String.valueOf(item1);
            if (!map.containsKey(wordhash))
                map.put(wordhash, new ArrayList<Integer>(Arrays.asList(i)));
            else
                map.get(wordhash).add(i);
        }
        for (ArrayList<Integer> value : map.values()) {
            List<String> temp = new ArrayList<String>();
            for (int i = 0; i < value.size(); i++)
                temp.add(strs[value.get(i)]);
            res.add(temp);
        }
        return res;
    }
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}
