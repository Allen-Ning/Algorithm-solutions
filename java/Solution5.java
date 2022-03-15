class Solution {
    public String longestPalindrome(String s) {
        int size = s.length();
        boolean[][] dp = new boolean[size][size];
        int start = -1;
        int end = -1;

        for (int length = 0; length < size; length++) {
            for (int i = 0; i < size; i++) {
                int j = length + i;
                if (j >= size) continue;
    
                dp[i][j] = s.charAt(i) == s.charAt(j);
                if (j - i >= 2) {
                    dp[i][j] = dp[i][j] && dp[i + 1][j - 1];
                }

                if (dp[i][j]) {
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}