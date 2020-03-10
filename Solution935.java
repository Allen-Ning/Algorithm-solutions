class Solution {
    public int knightDialer(int N) {
        long[] dp = new long[10];
        Arrays.fill(dp, 1);
        // trick -> 10^9 + 7 is actually 26
        //          1000000007 (this is actually less than Integer.MAX_VALUE) 
        //          2147483647
        long max = 1_000_000_007;
        for (int i = 1; i < N; i++) {
            long[] dp2 = new long[10];
            dp2[0] = (dp[4] + dp[6]) % max;
            dp2[1] = (dp[8] + dp[6]) % max;
            dp2[2] = (dp[7] + dp[9]) % max;
            dp2[3] = (dp[4] + dp[8]) % max;
            dp2[4] = (dp[0] + dp[3] + dp[9]) % max;
            dp2[6] = (dp[0] + dp[1] + dp[7]) % max;
            dp2[7] = (dp[2] + dp[6]) % max;
            dp2[8] = (dp[1] + dp[3]) % max;
            dp2[9] = (dp[2] + dp[4]) % max;
            dp = dp2;
        }

        long result = 0;a
        for (int i = 0; i < dp.length; i++) result += dp[i] % max;
        return (int) (result % max);
    }
}
