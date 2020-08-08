class Solution {
    public int minScoreTriangulation(int[] A) {
        // trick -> we need start index -> 0, and end index 5 for e.g [1,3,1,4,1,5]
        //          so that we can easily cut k in the middle
        // dp[0][5]
        // dp[0][2] dp[1][3] dp[2][4] dp[3][5]
        // dp[0][3] dp[1][4] dp][2][5]
        // dp[0][4] dp[1][5]
        // dp[0][5]
        int[][] dp = new int[A.length][A.length];
        for (int d = 2; d < A.length; d++) {
            for (int i = 0; i < A.length; i++) {
                int start = i;
                int end = start + d;
                if (end >= A.length) continue;

                dp[start][end] = Integer.MAX_VALUE;
                for (int k = start + 1; k < end; k++) {
                    dp[start][end] = Math.min(dp[start][end], dp[start][k] + A[start] * A[end] * A[k] + dp[k][end]);
                }
            }
        }
        return dp[0][dp.length - 1];
    }
}