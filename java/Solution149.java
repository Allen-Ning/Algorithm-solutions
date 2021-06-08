import java.math.BigDecimal;
import java.math.MathContext;

// Note: there is a slightly better solution to use only counter (I think it might easily introduce bugs)
// which is a little bit better for calc time, but same time complexisity
class Solution {
    // y1 = ax1 + c
    // y2 = ax2 + c
    // a = (y2 - y1) / (x2 - x1);
    // c = y1 - ax1;
    // c = y1 - x1 (y2 - y1) / (x2 - x1);
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) return 0;
        if (points.length <= 1) return points.length;

        int max = 0;
        HashMap<String, HashSet<String>> map = new HashMap();
        HashSet<String> set = null;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int[] point1 = points[i];
                int[] point2 = points[j];
                String point1Id = "index: " + i + point1[0] + ":" + point1[1];
                String point2Id = "index: " + j + point2[0] + ":" + point2[1];
                int x1 = point1[0];
                int y1 = point1[1];
                int x2 = point2[0];
                int y2 = point2[1];

                if (point1[0] + point1[1] <= point2[0] + point2[1]) {
                    x1 = point2[0];
                    y1 = point2[1];
                    x2 = point1[0];
                    y2 = point1[1];
                }

                String key = "";
                if (point2[0] == point1[0]) {
                    key = "x=" + point1[0];
                } else {
                    BigDecimal temp = BigDecimal.valueOf(y2 - y1).divide(BigDecimal.valueOf(x2 - x1), new MathContext(8));
                    BigDecimal temp2 = BigDecimal.valueOf(x1).multiply(temp);
                    BigDecimal c = BigDecimal.valueOf(y1).subtract(temp2);
                    BigDecimal a = temp;
                    key = a + "->"+ c;
                }

                set = map.containsKey(key) ? map.get(key) : new HashSet();
                set.add(point1Id);
                set.add(point2Id);
                map.put(key, set);
                max = Math.max(max, set.size());
            }
        }
        return max;
    }

    // y1 = ax1 + c
    // y2 = ax2 + c
    // a = (y2 - y1) / (x2 - x1);
    // c = y1 - ax1;
    // c = y1 - x1 (y2 - y1) / (x2 - x1);
    // trick -> (slope) A point with B Point are same as A Point with C Point
    // A, B, C are on the same line
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) return 0;
        if (points.length <= 1) return points.length;

        int max = 0;
        HashMap<String, HashSet<String>> map = new HashMap();
        HashSet<String> set = null;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int[] point1 = points[i];
                int[] point2 = points[j];
                String point1Id = i + point1[0] + ":" + point1[1];
                String point2Id = j + point2[0] + ":" + point2[1];
                int y = point2[1] - point1[1];
                int x = point2[0] - point1[0];

                String key = "";
                if (point2[0] == point1[0]) {
                    key = "x=" + point1[0];
                } else {
                    int value = generateGCD(y, x);
                    y = y / value;
                    x = x / value;
                    key = y + "->" + x;
                }

                if (!map.containsKey(key)) {
                    set = new HashSet();
                    set.add(point1Id);
                    set.add(point2Id);
                } else {
                    set = map.get(key);
                    if (set.contains(point1Id)) set.add(point2Id);
                    if (set.contains(point2Id)) set.add(point1Id);
                }

                map.put(key, set);
                max = Math.max(max, set.size());
            }
        }
        return max;
    }

    // trick -> find the max value which could be divided by X and Y
    private int generateGCD(int x, int y) {
      if (y == 0) return x;
      return generateGCD(y, x % y);
  }
}
