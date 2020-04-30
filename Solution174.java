class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int r = dungeon.length;
        int c = dungeon[0].length;
        // trick -> dp indicates the mininium value of life when entering the ceil(i, j)
        //          dp[i][j] at least one to make sure the knight is still alive
        long[][] dp = new long[r + 1][c + 1];
        for (int i = 0; i < dp.length; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        for (int i = r - 1; i >= 0; i--) {
            for (int j = c - 1; j >= 0; j--) {
                // trick -> starting point
                if (i == r - 1 && j == c - 1) {
                   dp[i][j] = dungeon[i][j] > 0 ? 1 : 1 - dungeon[i][j];
                   continue;
                }

                if (dungeon[i][j] >= dp[i + 1][j] || dungeon[i][j] >= dp[i][j + 1]) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j] - dungeon[i][j], dp[i][j + 1] - dungeon[i][j]);
                }
            }
        }
        return (int) dp[0][0];
    }
}
