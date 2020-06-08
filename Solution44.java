class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*') dp[0][i] = dp[0][i - 1];
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                // trick -> when last chars in s and p are same or p last char is ?
                //          abc == dec
                //          abc == de?
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                // trick -> the last char in p is *
                //          abc == abc* => check abc == abc (* means empty)
                //          abcc == abc* => check abc == abc* (* means multiple chars) (hard to come up)
                } else if (p.charAt(j - 1) == '*'){
                     dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}