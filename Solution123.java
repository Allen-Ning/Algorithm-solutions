class Solution {
    public int maxProfit(int[] prices) {
        int days = prices.length + 1;
        int numOfTransations = 3;
        int numOfStatuses = 2;
        long[][][] dp = new long[numOfTransations][days][numOfStatuses];
        for (int i = 0; i < numOfTransations; i++) {
            Arrays.fill(dp[i][0], Integer.MIN_VALUE);
        }
        dp[0][0][0] = 0;
        long result = 0;
        for (int i = 1; i < days; i++) {
            int price = prices[i - 1];
            for (int j = 0; j < numOfTransations; j++) {
                // k transaction, day: i, current status: buyable
                dp[j][i][0] = (j == 0 ? dp[j][i - 1][0] : Math.max(dp[j - 1][i - 1][1] + price, dp[j][i - 1][0]));
                // k transaction, day: i, current status: sellable
                dp[j][i][1] = Math.max(dp[j][i - 1][0] - price, dp[j][i - 1][1]);
                result = Math.max(result, Math.max(dp[j][i][0], dp[j][i][1]));
            }
        }
        return (int) result;
    }

    public int maxProfitRawVersion(int[] prices) {
        int days = prices.length + 1;
        long[][][] dp = new long[3][days][2];
        dp[0][0][1] = Integer.MIN_VALUE;
        dp[0][0][0] = 0;
        dp[1][0][0] = Integer.MIN_VALUE;
        dp[1][0][1] = Integer.MIN_VALUE;
        dp[2][0][0] = Integer.MIN_VALUE;
        dp[2][0][1] = Integer.MIN_VALUE;
        for (int i = 1; i < days; i++) {
            int price = prices[i - 1];
            // 0 transaction, day: i, current status: buyable
            dp[0][i][0] = dp[0][i - 1][0];
            // 0 transaction, day: i, current status: sellable
            dp[0][i][1] = Math.max(dp[0][i - 1][0] - price, dp[0][i - 1][1]);

            // 1 transaction, day: i, current status: buyable
            dp[1][i][0] = Math.max(dp[0][i - 1][1] + price, dp[1][i - 1][0]);
            // 1 transaction, day: i, current status: sellable
            dp[1][i][1] = Math.max(dp[1][i - 1][0] - price, dp[1][i - 1][1]);

            // 2 transaction, day: i, current status: buyable
            dp[2][i][0] = Math.max(dp[1][i - 1][1] + price, dp[2][i - 1][0]);
            // 2 transaction, day: i, current status: buyable
            dp[2][i][1] = Math.max(dp[2][i - 1][0] - price, dp[2][i - 1][1]);
        }

        long result = 0;
        result = Math.max(result, dp[0][days - 1][0]);
        result = Math.max(result, dp[0][days - 1][1]);
        result = Math.max(result, dp[1][days - 1][0]);
        result = Math.max(result, dp[1][days - 1][1]);
        result = Math.max(result, dp[2][days - 1][0]);
        result = Math.max(result, dp[2][days - 1][1]);
        return (int) result;
    }

}
