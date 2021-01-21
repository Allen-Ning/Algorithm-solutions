class Solution {
    public int numberOfSets(int N, int K) {
        //  trick -> dp[k][i] indicates the number of ways to draw k non-overlapping line segments ending with index i
        //           preSum[i][k] = dp[i][k] + dp[i - 1][k] + .... + dp[0][k], which is for saving one loop to speedup
        //  dp[i][k] = 1 -> dp[i - 1][k - 1] + 
        //             2 -> dp[i - 2][k - 1] +
        //             3 -> dp[i - 3][k - 1] +
        //             n -> dp[0][k - 1]
        //
        //            n + 1 -> dp[i- 1][k]

        // e.g.
        // dp[4][1] = (
        //             dp[3][0] 
        //             dp[2][0]
        //             dp[1][0]
        //             dp[0][0]
        //            )
        //            dp[3][1]
        // preSum[4][1] = preSum[3][1] + dp[4][1]

        // dp[4][2] = (
        //             dp[3][1] 
        //             dp[2][1]
        //             dp[1][1]
        //             dp[0][1]
        //            )
        //            dp[3][2]
        // preSum[4][2] = preSum[3][2] + dp[4][2]
        int mod = (int) Math.pow(10, 9) + 7;
        int[][] dp = new int[N][K + 1];
        int[][] preSum = new int[N][K + 1];
        dp[0][0] = 1;
        preSum[0][0] = 1;
        for (int i = 1; i < N; i++) {
            for (int k = 0; k <= Math.min(i, K); k++) {
                if (k == 0) {
                    dp[i][k] = 1;
                } else {
                    dp[i][k] = preSum[i - 1][k - 1] + dp[i - 1][k];
                    dp[i][k] %= mod;
                }
                preSum[i][k] = dp[i][k] + preSum[i - 1][k];
                preSum[i][k] %= mod;
            }
        }
        return dp[N - 1][K];
    }
}
