class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet();
        for (String word : words) set.add(word);
        List<String> results = new ArrayList();
        for (String word : words) {
            set.remove(word);
            if(canBreak(set, word)) results.add(word);
            set.add(word);
        }
        return results;
    }

    private boolean canBreak(Set<String> set, String word) {
        if (set.size() == 0 || word.length() == 0) return false;

        int size = word.length() + 1;
        // trick -> dp indicates word length from length 0 to word.length()
        boolean[] dp = new boolean[size];
        // trick -> be careful about the dp[0] = true
        dp[0] = true;
        // trick -> be careful about the j starting from 0 ending before i
        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j]) continue;
                if (set.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
}
