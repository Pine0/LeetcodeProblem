public class Leetcode_242 {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] sBool = new int[26];
        for (int i = 0; i < s.length(); i++)
            sBool[s.charAt(i) - 'a'] += 1;
        for (int i = 0; i < t.length(); i++)
            if (--sBool[t.charAt(i) - 'a'] < 0)
                return false;
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isAnagram("ab", "a"));
    }

}
