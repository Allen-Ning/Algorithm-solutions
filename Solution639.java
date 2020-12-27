class Solution {
    public int numDecodings(String s) {
        // dp indicates how many letters from 0 to s.length();
        int[] dp = new int[s.length() + 1];
        int mod = (int) Math.pow(10, 9) + 7;
        dp[0] = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            int num = s.length() - i;
            char c = s.charAt(i);
            if (c == 0) continue;

            if (c >= '1' && c <= '9') {
                dp[num] += dp[num - 1] * 1;
            } else if (c == '*') {
                dp[num] += dp[num - 1] * 9;
            }
            dp[num] %= mod;

            if (num <= 1) continue;
            dp[num] += dp[num - 2] * counter(s, i);
            dp[num] %= mod;
        }
        return dp[s.length()];
    }

    private int counter(String s, int i) {
        if (i + 1 >= s.length()) return 0;

        char current = s.charAt(i);
        char next = s.charAt(i + 1);
        if (current == '1') {
            if (next >= '0' && next <= '9') return 1;
            // 11 -> 19 (9)
            if (next == '*') return 9;
            return 1;
        } else if (current == '2') {
            if (next >= '0' && next <= '6') return 1;
            // 21 -> 26 (6)
            if (next == '*') return 6;
        } else if (current == '*') {
            // 16
            // 26
            if (next >= '0' && next <= '6') return 2;
            // 17
            if (next > '6' && next <= '9') return 1;
            // 11 -> 19 (9)
            // 21 -> 26 (6)
            if (next == '*') return 15;
            return 2;
        }
        return 0;
    }
}