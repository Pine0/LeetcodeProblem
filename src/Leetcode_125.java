public class Leetcode_125 {
    /*
    125. Valid Palindrome  Easy

    Given a string, determine if it is a palindrome,
    considering only alphanumeric characters and
    ignoring cases.

    Note: For the purpose of this problem, we define
    empty string as valid palindrome.
     */
    private static boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
    private static boolean isNotEqual(char c1, char c2) {
        String s1 = String.valueOf(c1);
        String s2 = String.valueOf(c2);
        return !s1.equalsIgnoreCase(s2);
    }
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char cLeft = s.charAt(left), cRight = s.charAt(right);
            if (isLetter(cLeft) && isLetter(cRight)) {
                if (isNotEqual(cLeft,cRight))
                    return false;
                left ++;
                right --;
            }
            else if (!isLetter(cLeft)) {
                left++;
            }
            else if (!isLetter(cRight)) {
                right--;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }
}
