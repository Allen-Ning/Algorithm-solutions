class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 2; i < dp[0].length; i++) {
            if (p.charAt(i - 1) == '*') dp[0][i] = dp[0][i - 2];
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                // trick -> when the last char of s and the last of p are same
                //          or the last char of p is .
                //              e.g.
                //              abc == abc
                //              abc == ab.
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                // trick -> when the last char of p is *
                //              e.g.
                //              abc == abc* ( * means one c) -> abc == abc
                //              abc == abc* (* means zero c) -> abc == ab
                //              when the last char of s and the second last char of p are matched
                //              abcc == ab.* (* means 2 c) -> abc == ab.*
                //              abcc == abc* (* means 2 c) -> abc == abc*
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i][j - 2];
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) dp[i][j] = dp[i][j] || dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}