class Solution {
    public int numWays(int steps, int arrLen) {
        // trick -> this is to avoid arrLen much bigger than steps
        //          (step / 2) is for the farest index we can go,
        //          if we go further than (step / 2), we cannot return back.
        int maxLength = Math.min(steps / 2 + 1, arrLen);
        long[][] dp = new long[steps + 1][maxLength];
        dp[0][0] = 1;

        // trick -> this is actually smaller than Integer.MAX_VALUE
        int mod = (int) (Math.pow(10, 9) + 7);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] += (dp[i - 1][j] % mod);
                if (j - 1 >= 0) dp[i][j] += (dp[i - 1][j - 1] % mod);
                if (j + 1 < dp[i].length) dp[i][j] += (dp[i - 1][j + 1] % mod);
            }
        }
        return (int)(dp[dp.length - 1][0] % mod);
    }
}