class Solution {
    public int maxProfit(int k, int[] prices) {
        // trick -> when k >= prices.length / 2, we can do as much transaction as we need
        if (k >= prices.length / 2) return quickCal(prices);

        k = Math.min(k, prices.length / 2);
        long[][] dp = new long[k + 1][2];
        long[][] preDP = new long[k + 1][2];
        for (int i = 0; i < preDP.length; i++) {
            Arrays.fill(preDP[i], Integer.MIN_VALUE);
        }
        preDP[0][0] = 0;

        long result = 0;
        for (int i = 1; i < prices.length + 1; i++) {
            int price = prices[i - 1];
            for (int j = 0; j < dp.length; j++) {
                if (j >= 1) {
                    dp[j][0] = Math.max(preDP[j - 1][1] + price, preDP[j][0]);
                } else {
                    dp[j][0] = preDP[j][0];
                }
                dp[j][1] = Math.max(dp[j][0] - price, preDP[j][1]);
                result = Math.max(result, dp[j][0]);
                result = Math.max(result, dp[j][1]);
            }
            preDP = dp;
        }
        return (int) result;
    }

    private int quickCal(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) result += prices[i] - prices[i - 1];
        }
        return result;
    }
}
