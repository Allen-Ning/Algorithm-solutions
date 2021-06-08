class Solution {
  public int numDecodings(String s) {
    int[] dp = new int[s.length() + 1];
    dp[0] = 1;
    dp[1] = s.charAt(0) != '0' ? 1 : 0;

    for (int i = 2; i < dp.length; i++) {
      String oneLetter = s.substring(i - 1, i);
      String twoLetters = s.substring(i - 2, i);

      if (1 <= Integer.valueOf(oneLetter) && Integer.valueOf(oneLetter) <= 9) {
        dp[i] += dp[i -1];
      }

      if (10 <= Integer.valueOf(twoLetters) && Integer.valueOf(twoLetters) <= 26) {
        dp[i] += dp[i -2];
      }
    }

    return dp[s.length()];
  }
}
