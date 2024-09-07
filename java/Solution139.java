class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet();
        for (String word : wordDict) set.add(word);

        // trick -> dp indicdats if the string with the given length has shown in wordDict
        //          e.g
        //          0 1 2 3 4 5 6 7
        //          l e e t c o d e
        //          dp[0] means empty string
        //          dp[7] means "leetcode"
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
