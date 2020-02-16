class Solution {
    public int maxCoins(int[] nums) {
        int[] values = new int[nums.length + 2];
        for (int i = 0; i < values.length; i++) {
            if (i == 0 || i == values.length - 1) {
                values[i] = 1;
                continue;
            }
            values[i] = nums[i - 1];
        }

        int[][] dp = new int[values.length][values.length];
        for (int d = 1; d < values.length; d++) {
            for (int l = 0; l < values.length; l++) {
                int r = l + d;
                if (r >= values.length) continue;

                for (int i = l + 1; i < r; i++) {
                    dp[l][r] = Math.max(dp[l][r], dp[l][i] + values[i] * values[l] * values[r] + dp[i][r]);
                }
            }
        }
        return dp[0][values.length - 1];
    }
}
