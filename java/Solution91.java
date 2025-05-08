class Solution {
  public int numDecodings(String s) {
    int[] dp = new int[s.length() + 1];
    dp[0] = 1;
    dp[1] = s.charAt(0) != '0' ? 1 : 0;

    for (int i = 2; i < dp.length; i++) {
      Integer oneLetter = Integer.valueOf(s.substring(i - 1, i));
      Integer twoLetters = Integer.valueOf(s.substring(i - 2, i));

      if (1 <= oneLetter && oneLetter <= 9) {
        dp[i] += dp[i -1];
      }

      if (10 <= twoLetters && twoLetters <= 26) {
        dp[i] += dp[i -2];
      }
    }

    return dp[s.length()];
  }
}
