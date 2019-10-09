class Solution {
    public int change(int amount, int[] coins) {
        if (amount == 0) return 1;
        if (coins == null || coins.length == 0) return 0;
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < dp.length; i++) dp[i][0] = 1;
        for (int i = 1; i < dp[0].length; i++) dp[0][i] = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int value = 0;
                if (j >= coins[i - 1]) {
                    int x = j - coins[i - 1];
                    value = dp[i][x];
                }
                dp[i][j] = dp[i - 1][j] + value;
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
