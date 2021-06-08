class Solution {
    private int max = 0;
    private int[][] grid;
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        this.grid = grid;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                travel(i, j);
            }
        }
        return max;
    }

    public int travel(int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) return 0;

        int num = 1;
        grid[i][j] = 0;
        num += travel(i, j + 1);
        num += travel(i + 1, j);
        num += travel(i, j - 1);
        num += travel(i - 1, j);
        max = Math.max(max, num);

        // trick -> not need to reset grid[i][i] = 1
        // cos we would like to say the clear the 1s
        // and make sure 1s are only being used one time
        // grid[i][j] = 1;
        return num;
    }
}
