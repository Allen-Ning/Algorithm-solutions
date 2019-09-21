class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;

        int counter = 0;
        int[][] dp = new int[s.length()][s.length()];
        for (int start = s.length() - 1; start >= 0; start--) {
            for (int end = start; end < s.length(); end++) {
                if (s.charAt(start) == s.charAt(end)) {
                    // trick -> two pattern a(b)a or a(bbbbbb)a
                    dp[start][end] = (end - start <= 2) ? 1 : dp[start + 1][end - 1];
                    if (dp[start][end] == 1) counter++;
                }
            }
        }
        return counter;
    }
}
