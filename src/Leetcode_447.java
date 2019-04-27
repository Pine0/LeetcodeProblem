import java.util.HashMap;
import java.util.Map;

public class Leetcode_447 {
    /*
    447. Number of Boomerangs  Easy

    Given n points in the plane that are
    all pairwise distinct, a "boomerang"
    is a tuple of points (i, j, k) such
    that the distance between i and j
    equals the distance between i and k
    (the order of the tuple matters).

    Find the number of boomerangs. You
    may assume that n will be at most
    500 and coordinates of points are
    all in the range [-10000, 10000]
    (inclusive).

     */
    public static int numberOfBoomerangs(int[][] points) {
        int cnt = 0;
        Map<Double, Integer> map = new HashMap<Double, Integer>();
        for (int i = 0; i < points.length ; i++) {
            for (int j = 0; j < points.length; j++){
                if (i == j) continue;
                double distance = Math.pow(Math.abs(points[i][0] - points[j][0]),2) +
                        Math.pow(Math.abs(points[i][1] - points[j][1]),2);
                if (!map.containsKey(distance))
                    map.put(distance, 1);
                else
                    map.put(distance, map.get(distance) + 1);
            }
            for (Integer value : map.values())
                cnt += value * (value - 1);
            map.clear();

        }
        return cnt;

    }
    public static void main(String[] args) {
        int[][] points = {{0,0},{1,0},{-1,0},{0,1},{0,-1}};
        System.out.println(numberOfBoomerangs(points));
    }
}
