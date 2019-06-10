class Solution {
  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, -1);
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
      int min = Integer.MAX_VALUE;
      for (int coin: coins) {
        if (i >= coin && dp[i - coin] != -1) {
          min = Math.min(min, dp[i - coin] + 1);
          dp[i] = min;
        } 
      }
    }
    return dp[amount];
  }
}
