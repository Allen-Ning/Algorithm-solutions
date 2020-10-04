public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int[] cols = new int[grid[0].length];
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            int row = 0;
            for (int j = 0; j < grid[0].length; j++) {
                // trick -> pre-calculate the row, re-calculate when first column or left cell is 'W'
                if (j == 0 || grid[i][j - 1] == 'W') row = serachRight(grid, i, j);
                // trick -> pre-calculate the cols, re-calculate when first row or above cell is 'W'
                if (i == 0 || grid[i - 1][j] == 'W') cols[j] = searchBottom(grid, i, j);

                if (grid[i][j] == '0') result = Math.max(result, row + cols[j]);
            }
        }
        return result;
    }

    private int serachRight(char[][] grid, int x, int y) {
        int result = 0;
        for (int j = y; j < grid[0].length; j++) {
            if (grid[x][j] == 'E') {
                result++;
            } else if (grid[x][j] == 'W') {
                break;
            }
        }
        return result;
    }

    private int searchBottom(char[][] grid, int x, int y) {
        int result = 0;
        for (int i = x; i < grid.length; i++) {
            if (grid[i][y] == 'E') {
                result++;
            } else if (grid[i][y] == 'W') {
                break;
            }
        }
        return result;
    }
}