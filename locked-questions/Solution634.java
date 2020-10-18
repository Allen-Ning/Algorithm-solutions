public class Solution {
    // trick -> pure math question. two scenarios are needed to be considered
    //          1 2 k 4 5 6 N
    //          1. when N and K swop -> (n - 1) * dp[n - 2]
    //          2. when N is placed in K, but K not placed in N -> (n - 1) * dp[n -1]
    public int findDerangement(int n) {
        if (n <= 1) return 0;
        if (n == 2) return 1;

        long[] dp = new long[n + 1];
        int mod = (int) Math.pow(10, 9) + 7;
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = ((i - 1) * (dp[i - 1] + dp[i - 2])) % mod;
        }
        return (int) dp[n];
    }
}