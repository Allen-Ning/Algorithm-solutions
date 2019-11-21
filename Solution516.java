class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
          dp[i][i] = 1;
          for (int j = i - 1; j >= 0; j--) {
            if (s.charAt(i)== s.charAt(j)) {
              dp[i][j] = dp[i - 1][j + 1] + 2;
            } else {
              dp[i][j] = Math.max(dp[i - 1][j], dp[i][j + 1]);
            }
          }
        }
        return dp[s.length() - 1][0];
    }
}
