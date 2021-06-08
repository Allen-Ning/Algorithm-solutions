class Solution {
    public double minAreaFreeRect(int[][] points) {
        // x -> a set of y
        Map<Integer, Set<Integer>> map = new HashMap();
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            Set<Integer> set =  map.getOrDefault(x, new HashSet());
            set.add(y);
            map.put(x, set);
        }

        double result = Double.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int[] point1 = points[i];
            for (int j = 0; j < points.length; j++) {
                if (j == i) continue;
                int[] point2 = points[j];
                for (int z = 0; z < points.length; z++) {
                    if (z == i || z == j) continue;
                    int[] point3 = points[z];
                    int x1 = point1[0];
                    int x2 = point2[0];
                    int x3 = point3[0];
                    int y1 = point1[1];
                    int y2 = point2[1];
                    int y3 = point3[1];

                    // slope1: (x2 - x1) / (y2 - y1);
                    // slope2: (x2 - x3) / (y2 - y3);
                    // slope1 * slope2 == 0
                    int slope = (x2 - x1) * (x2 - x3) + (y2 - y1) * (y2 - y3);
                    // trick -> this is use veritical two sides to fix point1, point2 and point3
                    if (slope != 0) continue;

                    // trick -> this is for find the valid point 4
                    //         x1 + (x3 - x1) / 2 = x2 + (x4 - x2) / 2 -> x4 = x1 + x3 - x2
                    //         y1 + (y3 - y1) / 2 = y2 + (y4 - y2) / 2 -> y4 = y1 + y3 - y2
                    int x4 = x1 + x3 - x2;
                    int y4 = y1 + y3 - y2;
                    if (map.containsKey(x4) && map.get(x4).contains(y4)) {
                        double side1 = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
                        double side2 = Math.sqrt((x2 - x3) * (x2 - x3) + (y2 - y3) * (y2 - y3));
                        result = Math.min(result, side1 * side2);
                    }
                }
            }
        }
        return result == Double.MAX_VALUE ? 0 : result;
    }
}
