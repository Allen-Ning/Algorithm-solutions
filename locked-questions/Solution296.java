public class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> xAxisProject = new ArrayList();
        List<Integer> yAxisProject = new ArrayList();
        List<int[]> points = new ArrayList();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    yAxisProject.add(i);
                    points.add(new int[] {i, j});
                }
            }
        }

        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 1) {
                    xAxisProject.add(j);
                }
            }
        }

        int medianY = findMedian(xAxisProject);
        int medianX = findMedian(yAxisProject);

        int result = 0;
        for (int[] point : points) {
            result += Math.abs(point[0] - medianX) + Math.abs(point[1]- medianY);
        }
        return result;
    }
    
    private int findMedian(List<Integer> list) {
        int l = 0;
        int h = list.size() - 1;
        int m = l + (h - l) / 2;
        return list.get(m);
    }
}