class Solution {

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) return 0;
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if(grid[i][j] == '1') {
          // trick -> both dfs and bfs should work
          dfs(grid, i, j);
          count++;
        }
      }
    }
    return count;
  }

  public void dfs(char[][] grid, int i, int j) {
    if (i >= 0 && 
        j >= 0 && 
        i < grid.length && 
        j < grid[0].length 
        && grid[i][j] == '1' 
    ) {
      // trick -> use 2 to avoid global boolean[][] isVisited
      grid[i][j] = '2';
      dfs(grid, i, j + 1);
      dfs(grid, i + 1, j);
      dfs(grid, i, j - 1);
      dfs(grid, i - 1, j);
    }
  }
}