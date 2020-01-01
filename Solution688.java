class Solution {
    public double knightProbability(int N, int K, int r, int c) {
      int[][] dirs = new int[][]{{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

      double[][] dp = new double[N][N];
      double[][] dp2 = new double[N][N];
      dp[r][c] = 1;

      int counter = 0;
      while (counter < K) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int[] dir : dirs) {
                    int x = dir[0] + i;
                    int y = dir[1] + j;
                    if (x >= 0 && x < N && y >= 0 && y < N) dp2[x][y] += dp[i][j];
                } 
            }
        }
        dp = dp2;
        dp2 = new double[N][N];
        counter++;
      }

      double total = 0;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          total += dp[i][j];
        }
      }

      return total / Math.pow(8, K);
    }
}
