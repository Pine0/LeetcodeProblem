public class Leetcode_451 {
    /*
    451. Sort Characters By Frequency  Medium

    Given a string, sort it in decreasing
    order based on the frequency of characters.
     */
    //如果有大量的String相加，StringBuffer要快得多
    public static String frequencySort(String s) {
        int[] times = new int['z' - ' ' + 1];
        String[] res = new String[s.length() + 1];
        StringBuffer temp ;
        for (int i = 0; i < s.length(); i++)
            times[s.charAt(i) - ' ']++;
        for (int i = 0; i < times.length; i++) {
            if (times[i] != 0) {
                temp = new StringBuffer("");
                for (int j = 0; j <times[i]; j++)
                    temp.append(String.valueOf((char)(i + ' ')));
                if (res[times[i]] == null)
                    res[times[i]] = temp.toString();
                else
                    res[times[i]] += temp;

            }
        }
        temp = new StringBuffer("");
        for (int i = res.length - 1; i >= 0; i--)
            if (res[i] != null)
                temp.append(res[i]);
        return temp.toString();
    }
    public static void main(String[] args) {
        System.out.println(frequencySort("2a554442f544asfasssffffasss"));
    }
}
