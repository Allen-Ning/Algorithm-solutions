class Solution {
    public int minAreaRect(int[][] points) {
        if (points == null || points.length == 0) return 0;

        // trick -> one set is enough for this question
        HashMap<Integer, Set<Integer>> xMap = new HashMap();
        Set<Integer> values;
        for (int[] point : points) {
            values = xMap.getOrDefault(point[0], new HashSet<Integer>());
            values.add(point[1]);
            xMap.put(point[0], values);
        }

        int result = Integer.MAX_VALUE;
        boolean hasResult = false;
        for (int[] point1 : points) {
            for (int[] point2 : points) {
                if (point1[0] == point2[0] || point1[1] == point2[1]) continue; 
                if(xMap.get(point1[0]).contains(point2[1]) &&
                xMap.get(point2[0]).contains(point1[1])) {
                    hasResult = true;
                    int value = Math.abs(point1[0] - point2[0]) * Math.abs(point1[1] - point2[1]);
                    result = Math.min(result, value);
                }
            }
        }
        return hasResult ? result : 0;
    }
}
