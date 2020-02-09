class Solution {
    public int cherryPickup(int[][] grid) {
        int N = grid.length;

        int[][][] dp = new int[N + 1][N + 1][N + 1];
        for (int i = 0;i <= N; i++) {
            for (int j = 0;j <= N; j++) {
                for (int x = 0;x <= N; x++) {
                    // trick -> setup all dp defualt as Integer.MIN_VALUE for easy check dp later
                    dp[i][j][x] = Integer.MIN_VALUE;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int x = 1; x <= N; x++) {
                    int y = i + j - x;
                    if (y < 1 || y > N) continue;
                    // trick -> left cornor is a special case
                    if (i == 1 && j == 1 && x == 1) {
                        dp[i][j][x] = (grid[i - 1][j - 1] == -1) ? Integer.MIN_VALUE : grid[i - 1][j - 1];
                        continue;
                    }

                    dp[i][j][x] = Math.max(dp[i - 1][j][x - 1], dp[i][j][x]);
                    dp[i][j][x] = Math.max(dp[i - 1][j][x], dp[i][j][x]);
                    dp[i][j][x] = Math.max(dp[i][j - 1][x - 1], dp[i][j][x]);
                    dp[i][j][x] = Math.max(dp[i][j - 1][x], dp[i][j][x]);

                    if (dp[i][j][x] == Integer.MIN_VALUE) continue;

                    if (i == x && j == y) {
                        if (grid[i - 1][j - 1] == -1) {
                            dp[i][j][x] = Integer.MIN_VALUE;
                            continue;
                        }
                        dp[i][j][x] += grid[i - 1][j - 1];
                    } else {
                        if (grid[i - 1][j - 1] == -1 || grid[x - 1][y - 1] == -1) {
                            dp[i][j][x] = Integer.MIN_VALUE;
                            continue;
                        }
                        dp[i][j][x] += grid[i - 1][j - 1] + grid[x - 1][y - 1];
                    }
                }
            }

        }
        return dp[N][N][N] == Integer.MIN_VALUE ? 0 : dp[N][N][N];
    }
}
