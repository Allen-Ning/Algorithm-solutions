class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) continue;
                result +=  (4 - count(grid, i, j));
            }
        }
        return result;
    }

    private int count(int[][] grid, int i, int j) {
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int counter = 0;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                counter++;
            }
        }
        return counter;
    }
}
