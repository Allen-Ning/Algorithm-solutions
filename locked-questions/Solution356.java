public class Solution {
    public boolean isReflected(int[][] points) {
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        Map<Integer, Map<Integer, Integer>> map = new HashMap();
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            // trick -> we need this to calculate the value of c
            if (y == points[0][1]) minX = Math.min(minX, x);
            if (y == points[0][1]) maxX = Math.max(maxX, x);

            Map<Integer, Integer> pointsAtSameLine = map.getOrDefault(y, new HashMap<Integer, Integer>());
            pointsAtSameLine.put(x, pointsAtSameLine.getOrDefault(x, 0) + 1);
            map.put(y, pointsAtSameLine);
        }

        // trick -> all points must follow this
        //          c is the x coordinator of line parallel to y axis
        // x - c = c - y
        // x + y = 2c
        int c = minX + maxX;
        for (int y : map.keySet()) {
            Map<Integer, Integer> pointsAtSameLine = map.get(y);
            for (int x : pointsAtSameLine.keySet()) {
                int value = pointsAtSameLine.get(x);
                if (value == 0) continue;
                int searchedX = c - x;
                if (!pointsAtSameLine.containsKey(searchedX)) return false;
                int searchedXValue = pointsAtSameLine.get(searchedX);
                if (value != searchedXValue) return false;
                pointsAtSameLine.put(x, 0);
                pointsAtSameLine.put(searchedX, 0);
            }
        }
        return true;
    }
}