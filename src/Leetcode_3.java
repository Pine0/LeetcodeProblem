public class Leetcode_3 {
    /*
    3. Longest Substring Without Repeating Characters  Medium

    Given a string, find the length of the
    longest substring without repeating
    characters.

     */

    private static int find(String s, int left, int right) {
        char c = s.charAt(right + 1);
        for (; left <= right; left++) {
            if (s.charAt(left) == c)
                return left;
        }
        return -1;
    }
    public static int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int maxLength = 0;
        if (s.length() == 0 || s.length() == 1) return s.length();
        while (right < s.length() - 1) {
            int index = find(s, left, right);
            if (index == -1) {
                right++;
            }
            else {
                left = index + 1;
                right++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        String s = " ";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
