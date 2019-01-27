class Solution {

  public int minPathSum(int[][] grid) {
    int rows = grid.length;
    int columns = grid[0].length;

    for (int i = 0; i < rows; i++) {
      for(int j = 0; j < columns; j++) {
        if (i == 0 && j == 0) {
          continue;
        } else if (i == 0) {
          grid[i][j] += grid[i][j -1];
        } else if (j == 0) {
          grid[i][j] += grid[i -1][j];
        } else {
          grid[i][j] = Math.min(grid[i][j-1], grid[i-1][j]) + grid[i][j];
        }
      }
    }
    return grid[rows -1][columns -1];
  }
}
