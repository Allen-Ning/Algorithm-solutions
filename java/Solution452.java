class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;

        // trick -> to sort the array by end of each point to simplify the logic
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        
        int[] current = points[0];
        int result = 1;
        for (int i = 1; i < points.length; i++) {
            if (current[1] >= points[i][0]) continue; 
            current = points[i];
            result++;
        }
        return result;
    }
}
