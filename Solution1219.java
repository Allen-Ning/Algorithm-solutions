class Solution {
    public int getMaximumGold(int[][] grid) {
        int[] result = new int[1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                helper(grid, result, i, j, 0);
            }
        }
        return result[0];
    }

    private void helper(int[][] grid, int[] result, int x, int y, int current) {
        if (x < 0 || 
            x >= grid.length ||
            y < 0 ||
            y >= grid[0].length ||
            grid[x][y] == 0
           ) return;

        int value = grid[x][y];
        grid[x][y] = 0;
        result[0] = Math.max(result[0], value + current);
        helper(grid,  result, x + 1, y, current + value);
        helper(grid,  result, x - 1, y, current + value);
        helper(grid,  result, x, y + 1, current + value);
        helper(grid,  result, x, y - 1, current + value);
        grid[x][y] = value;
    }
}
