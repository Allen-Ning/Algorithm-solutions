class Solution {
  public int uniquePaths(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n =  obstacleGrid[0].length;

    int[] result = new int[n];
    result[0] = 1;
    for (int i = 0; i < obstacleGrid.length; i++) {
      for ( int j = 0; j < obstacleGrid[0].length; j++) {
        if (obstacleGrid[i][j] == 1) {
          result[j] = 0;
        } else if (j > 0) {
          result[j] += result[j - 1];
        }
      }
    }

    return result[n -1];
  }
}
