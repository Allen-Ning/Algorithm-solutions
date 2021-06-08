class Solution {
    // 0 0 0 0 0 0 
    // 0 1 0 1 0 0
    // 0 1 0 1 1 1
    // 0 1 1 1 1 1
    // 0 1 0 0 1 0
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int result = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
               if (matrix[i - 1][j - 1] == '1') {
                   dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    result = Math.max(result, dp[i][j]);
               }
            } 
        }

        return result * result;
    }
}
