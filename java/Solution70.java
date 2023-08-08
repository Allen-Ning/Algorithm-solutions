class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i -2];
        }
        return dp[n];
    }

    public int climbStairs2(int n) {
        if (n <= 2) return n;

        int result = -1;
        int current = 3;
        int step1 = 1;
        int step2 = 2;
        while (current <= n) {
            result = step2 + step1;
            step1 = step2;
            step2 = result;

            current++;
        }
        return result;
    }
}