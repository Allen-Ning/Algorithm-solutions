
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
      int[] row = new int[grid.length];
      int[] column = new int[grid[0].length];
      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
          row[i] = Math.max(row[i], grid[i][j]);
          column[i] = Math.max(column[i], grid[j][i]);
        }
      }
      
      int result = 0;
      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
          result += (Math.min(column[i], row[j]) - grid[i][j]);
        }
      }
      return result;
    }
}
