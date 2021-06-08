class Solution {
  public int numSquares(int n) {
    dp[0] = 0;
    dp[1] = 1;
    int[] dp = new int[n + 1];
    for (int i = 2; i <= n; i++) {
      int min = Integer.MAX_VALUE;
      while (i - j * j >= 0) {
        int value = i - j * j;
        min = Math.min(min, dp[value] + 1);
        j++;
      }
    }
    return dp[n];
  }
}
