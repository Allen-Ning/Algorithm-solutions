class Solution {
    // "babgbag", T = "bag"
    //    0  b  a    b  g  b  a        g
    //  0 1  1  1    1  1  1  1        1
    //  b 0  1  1    2  2  3  3        3
    //  a 0  0 1*1+0 1  1  1  1*3+1    4
    //  g 0  0  0    0  1  1  1        1* 4 + 1
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int i = 0; i < dp[0].length; i++) dp[0][i] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i][j - 1] + 1 * dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}
