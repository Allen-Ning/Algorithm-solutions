class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] results = new int[N][N];
        for (int i = 0; i < results.length; i++) Arrays.fill(results[i], N);

        for (int[] mine : mines) results[mine[0]][mine[1]] = 0;

        // trick -> the most trick part to move like left, right, up, down
        // by using result[i][j] to move horizontal direction
        // by using result[j][i] to move vertical direction
        for (int i = 0; i < N; i++) {
          // left
          int left = 0;
          for (int j = 0; j < N; j++) {
            left = (results[i][j] == 0) ? 0 : (left + 1);
            results[i][j] = Math.min(results[i][j], left);
          }

          // right
          int right = 0;
          for (int j = N - 1; j >= 0; j--) {
            right = (results[i][j] == 0) ? 0 : (right + 1);
            results[i][j] = Math.min(results[i][j], right);
          }

          // up
          int up = 0;
          for (int j = 0; j < N; j++) {
            up = (results[j][i] == 0) ? 0 : (up + 1);
            results[j][i] = Math.min(results[j][i], up);
          }

          // down
          int down = 0;
          for (int j = N - 1; j >= 0; j--) {
            down = (results[j][i] == 0) ? 0 : (down + 1);
            results[j][i] = Math.min(results[j][i], down);
          }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
          for (int j = 0; j < N; j++) {
            max = Math.max(max, results[i][j]);
          }
        }

        return max;
    }
}
