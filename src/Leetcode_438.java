import java.util.*;

public class Leetcode_438 {
    /*
    438. Find All Anagrams in a String  Easy

    Given a string s and a non-empty string p, find
     all the start indices of p's anagrams in s.

    Strings consists of lowercase English letters
    only and the length of both strings s and p
    will not be larger than 20,100.

    The order of output does not matter.

     */
    private static Integer find (String s, int left, int right, int[] times2) {
        int[] times1 = new int[26];
        boolean flag = true;
        for (int i = left; i <= right; i++) {
            times1[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (times1[i] != times2[i]) {
                flag = false;
                break;
            }
        }
        if (!flag)
            return Integer.valueOf(-1);
        else
            return Integer.valueOf(left);
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> l = new ArrayList<Integer>();
        int[] times2 = new int[26];
        int left = 0, right = p.length() - 1;
        for (int i = 0; i < p.length(); i++) {
            times2[p.charAt(i) - 'a']++;
        }
        while (right <= s.length() - 1) {
            Integer index = find(s, left, right, times2);
            if (index != -1) {
                l.add(index);
            }
            left++;
            right++;
        }
        return l;
    }
    public static void main(String[] args) {
        String[] s = {"cbaebabacd", "a", ""};
        String[] p = {"abc", "a", "a"};
        for (int i = 0; i <s.length; i++) {
            List<Integer> l = findAnagrams(s[i], p[i]);
            for (int j = 0; j < l.size(); j++) {
                System.out.print(l.get(j).toString() + " ");
            }
            System.out.println();
        }

    }
}
