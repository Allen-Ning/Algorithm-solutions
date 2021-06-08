class Solution {
    public int palindromePartition(String s, int K) {
        int length = s.length();
        // trick -> another dp to pre-calculate the minimal number of characters that need to change to reduce time complesity
        int[][] counter = count(s);
        int[][] dp = new int[length][K + 1];
        for (int i = 0; i < length; i++) Arrays.fill(dp[i], length);
        for (int i = 0; i < length; i++) {
            for (int k = 1; k <= K; k++) {
                if (k == 1) {
                    dp[i][k] = counter[0][i];
                    continue;
                }

                for (int j = i - 1; j >= 0; j--) {
                    dp[i][k] = Math.min(dp[i][k], dp[j][k - 1] + counter[j + 1][i]);
                }
            }
        }
        return dp[length - 1][K];
    }

    private int[][] count(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int l = 1; l <= s.length() - 1; l++) {
            for (int i = 0; i < s.length(); i++) {
                int start = i;
                int end = start + l;
                if (end >= s.length()) break;

                if (s.charAt(end) != s.charAt(start)) dp[start][end] = 1;
                if (end - start >= 2) dp[start][end] += dp[start + 1][end - 1];
            }
        }
        return dp;
    }
}
