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

  public int numIslands2(char[][] grid) {
        /**
            bfs -> check visited
         */
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != '1') continue;
                bfs(grid, i, j);
                result++;
            }
        }
        return result;
    }

    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[] {i, j});
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        grid[i][j] = '0';

        while (queue.size() > 0) {
            int size = queue.size();
            for (int z = 0; z < size; z++) {
                int[] point = queue.poll();

                for (int[] dir : dirs) {
                    int nextX = point[0] + dir[0];
                    int nextY = point[1] + dir[1];
                    if (nextX < 0 || 
                        nextX >= grid.length ||
                        nextY < 0 ||
                        nextY >= grid[0].length ||
                        grid[nextX][nextY] != '1'
                    ) continue;

                    queue.offer(new int[] {nextX, nextY});
                    // trick -> marking visited here is quicker than marking when polling the nodes
                    grid[nextX][nextY] = '0';
                }
            }
        }
    }
}