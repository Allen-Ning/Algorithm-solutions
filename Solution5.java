class Solution {
    public String longestPalindrome(String s) {
      int length = s.length();
      boolean[][] dp = new boolean[length][length];
      String result = "";
      for (int i = 0; i < length; i++) {
        for (int j = i; j >=0; j--) {
          dp[i][j] = s.charAt(i) == s.charAt(j) && ( i - j < 3 || dp[i -1][j + 1]);
          if (dp[i][j] && i - j + 1 > result.length()) {
            result = s.substring(i, j + 1);
          }
        }
      }
      return result;
    }
}
