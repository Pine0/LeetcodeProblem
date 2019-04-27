public class Leetcode_76 {
    /*
    76. Minimum Window Substring  Hard

    Given a string S and a string T, find the
    minimum window in S which will contain
    all the characters in T in complexity O(n).

     */


    //自己实现的代码，但是时间超限
    private static boolean find (String s, int left, int right, int[] times2) {
        int[] times1 = new int[128];
        boolean flag = true;
        for (int i = left; i <= right; i++) {
            times1[s.charAt(i)]++;
        }
        for (int i = 0; i < 128; i++) {
            if (times1[i] < times2[i]) {
                flag = false;
                break;
            }
        }
        return flag;
    }
    public static String minWindow(String s, String t) {
        int left = 0, right = 0;
        int start = 0;
        int index = 0;
        boolean flag = false;
        int[] startIndex = new int[s.length()];
        for (int i = 0; i < s.length(); i++)
            startIndex[i] = -1;
        int minLength = s.length();
        int[] times2 = new int[128];
        for (int i = 0; i < t.length(); i++) {
            times2[t.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if(times2[s.charAt(i)] > 0) {
                startIndex[index] = i;
                index++;
            }
        }
        if (s.length() == t.length()) {
            if (find(s, 0,s.length() - 1, times2))
                return s;
            else
                return "";
        }
        if (s.length() < t.length() ||t.length()==0) return "";
        index = 0;

        outer : while (right < s.length() && left != -1) {
            int temp = 0;
            while (!find(s, left, right, times2)) {
                if (index + t.length() - 1 + temp >= startIndex.length)
                    break outer;
                right = startIndex[index + t.length() - 1 + temp];
                ++temp;
                if (right == -1)
                    break outer;
            }
            if (find(s, left, right, times2)) {
                flag = true;
                while (find(s, left, right, times2)) {
                    ++index;
                    left = startIndex[index];
                    if (left == -1)
                        break;
                }
                --index;
                left = startIndex[index];
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }
                if (index + t.length() < s.length() && startIndex[index + t.length()] != -1) {
                    left = startIndex[index + 1];
                    right = startIndex[index + t.length()];
                    index++;
                }
                else
                    break outer;

            }

        }
        if (flag)
            return s.substring(start, start + minLength);
        else
            return "";
    }



//    public static String minWindow(String s, String t) {
//        int count[] = new int[256];
//        for(int i = 0; i < t.length(); i++)
//            count[t.charAt(i)]++;
//        int sum = 0, slow = 0, minLength = s.length() + 1;
//        String result = "";
//        int current[] = new int[256];
//        for(int i = slow; i < s.length(); i++) {
//            int c = s.charAt(i);
//            current[c]++;
//            sum += (current[c] <= count[c] ? 1 : 0);
//            if( sum == t.length() ) {
//                while( slow < i && current[s.charAt(slow)] > count[s.charAt(slow)] ) {
//                    current[s.charAt(slow)]--;
//                    slow++;
//                }
//                if( i - slow + 1 < minLength ) {
//                    minLength = i - slow + 1;
//                    result = s.substring(slow, i + 1);
//                }
//                current[s.charAt(slow)]--;
//                slow++;
//                sum--;
//                while( slow < i && current[s.charAt(slow)] > count[s.charAt(slow)] ) {
//                    current[s.charAt(slow)]--;
//                    slow++;
//                }
//            }
//        }
//        return result;
//    }


    public static void main(String[] args) {
        String s = "aaaaaaaaaaaabbbbbcdd", t = "abcdd";
        System.out.println(minWindow(s, t));
    }
}
