import java.util.Map;
import java.util.HashMap;
public class Leetcode_205 {
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapS = new HashMap<Character, Character>();
        Map<Character, Character> mapT = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            if (!mapS.containsKey(s.charAt(i)))
                mapS.put(s.charAt(i), t.charAt(i));
            else if (!mapS.get(s.charAt(i)).equals(t.charAt(i)))
                return false;
        }
        for (Character value : mapS.values()) {
            if (!mapT.containsKey(value))
                mapT.put(value, null);
            else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String  s = "a", t = "a";
//        System.out.println(isIsomorphic(s, t));

    }
}
