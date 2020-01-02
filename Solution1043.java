class Solution {

    public int maxSumAfterPartitioning(int[] A, int K) {
        if (A == null || A.length == 0) return 0;

        int[] dp = new int[A.length + 1];
        dp[0] = 0;
        for (int i = 1; i <= A.length; i++) {
            int max = -1;
            int localMax = Integer.MIN_VALUE;
            int value = 0;
            // when k = 3
            // e.g. dp[4] = dp[3] + A[3]
            //            = dp[2] + Math.max(A[3], A[2]) * 2;
            //            = dp[1] + Math.max(A[3], A[2], A[1]) * 3;
            // trick -> we can do from j = 3 to 1 to avoid one more loop
            for (int j = i - 1; j >= i - K; j--) {
                if (j < 0) continue;
                value = dp[j];
                // trick -> this is actually trikc to save a loop
                localMax = Math.max(localMax, A[j]);
                value += localMax * (i - j);
                max = Math.max(value, max);
            }
            dp[i] = max;
        }
        return dp[A.length];
    }
}
