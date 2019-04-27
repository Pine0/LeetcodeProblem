import java.util.HashMap;
import java.util.Map;

public class Leetcode_290 {
    public static boolean wordPattern(String pattern, String str) {
        Map<String, String> map = new HashMap<String, String>();
        Map<String, String> map2 = new HashMap<String, String>();
        String[] strArray = str.split(" ");
        if (strArray.length != pattern.length())
            return false;
        for (int i = 0; i < pattern.length(); i++) {
            if (!map.containsKey(String.valueOf(pattern.charAt(i))))
                map.put(String.valueOf(pattern.charAt(i)), strArray[i]);
            else if (!map.get(String.valueOf(pattern.charAt(i))).equals(strArray[i]))
                return false;
        }
        for (String value : map.values()) {
            if (!map2.containsKey(value))
                    map2.put(value, "");
            else
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String pattern = pattern = "abba", str = "dog dog dog dog";
        System.out.println(wordPattern(pattern, str));
    }
}
