class Solution {
    public int maxTurbulenceSize(int[] A) {
        int dp[][] = new int[A.length][2];

        // trick -> dp[i][0] indicates down
        //          dp[i][1] indicates up
        int result = 1;
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                dp[i][1] = dp[i - 1][0] + 1;
                dp[i][0] = 1;
            } else if (A[i] < A[i - 1]) {
                dp[i][0] = dp[i - 1][1] + 1;
                dp[i][1] = 1;
            } else {
                dp[i][0] = 1;
                dp[i][1] = 1;
            }
            result = Math.max(dp[i][0], result);
            result = Math.max(dp[i][1], result);
        }
        return result;
    }
}
