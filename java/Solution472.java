class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        // trick -> sort first from shortest word to longest word
        Arrays.sort(words, (n1, n2) -> n1.length() - n2.length());

        List<String> results = new ArrayList();
        Set<String> set = new HashSet();

        for (int i = 0; i < words.length; i++) {
            if (canForm(words[i], set))
                results.add(words[i]);
            // trick -> only add word to set after checking to avoid
            // words[i] check against it itself in dp:
            // dp[s.length()] && set.contains(str.substring(0, s.length())
            set.add(words[i]);
        }
        return results;
    }

    private boolean canForm(String str, Set<String> set) {
        boolean[] dp = new boolean[str.length() + 1];
        // trick -> be careful about the dp[0] = true
        dp[0] = true;

        for (int i = 1; i <= str.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[i] = dp[j] && set.contains(str.substring(j, i));
                if (dp[i])
                    break;
            }
        }
        return dp[str.length()];
    }
}
