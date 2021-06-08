class Solution {
  public int largestIsland(int[][] grid) {
    if (grid == null || grid.length == 0) return 0;
    HashMap<Integer, Integer> map = new HashMap();

    int value = 2;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          helper(grid, map, value, i, j);
          value++;
        }
      }
    }

    int result = 0;
    // trick -> this is for checking the case 3
    // [[1, 1], [1, 1]]
    boolean hasZero = false;
    int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 0) {
          hasZero = true;
          HashSet<Integer> set = new HashSet();
          int temp = 1;
          for (int[] dir : dirs) {
            int newX = i + dir[0];
            int newY = j +  dir[1];

            if (newX >= 0 &&
                newX < grid.length &&
                newY >= 0 &&
                newY < grid[0].length &&
                grid[newX][newY] >= 2 &&
                set.add(grid[newX][newY])
               ) {
              temp += map.get(grid[newX][newY]);
               }
          }
          result = Math.max(result, temp);
        }
      }
    }
    return hasZero ? result : grid.length * grid[0].length;
  }

  private void helper(int[][] grid, HashMap<Integer, Integer> map, int value, int x, int y) {
    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return;
    if (grid[x][y] != 1) return;

    int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    grid[x][y] = value;
    map.put(value, map.getOrDefault(value, 0) + 1);

    for (int[] dir : dirs) helper(grid, map, value, x + dir[0], y + dir[1]);
  }
}
