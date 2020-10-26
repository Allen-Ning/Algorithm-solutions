public class Solution {
    public String minWindow(String S, String T) {
        int max = Math.max(S.length(), T.length());

        // dp[i][j] indicates the mininium length sub-string of S[0..j] ending with j to match T[0..i]
        int[][] dp = new int[T.length() + 1][S.length() + 1];
        for (int i = 0; i < dp.length; i++) dp[i][0] = max;
        for (int j = 0; j < dp[0].length; j++) dp[0][j] = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (T.charAt(i - 1) == S.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1] + 1;
                }
            }
        }

        String result = "";
        int minLength = max;
        for (int j = 0; j < dp[0].length; j++) {
            if (dp[dp.length - 1][j] < minLength) {
                minLength = dp[dp.length - 1][j];
                result = S.substring(j - minLength, j);
            }
        }
        return result;
    }
}