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

        //  0  1  2  3  4  5  6
        // [1, 1, 0, 0, 0, 0, 0]
        //
        // f(2) = f(2- 2) + f (2 - 1) = 2
        // f(3) = f(3 - 2) + f(3 - 1) = f(1) + f(2) = 1 + 2 = 3
        int step1 = 1;
        int step2 = 2;

        int step = -1;
        int i = 3;
        while (i <= n) {
            step = step1 + step2;
            step1 = step2;
            step2 = step;
            i++;
        }
        return step;
    }

}