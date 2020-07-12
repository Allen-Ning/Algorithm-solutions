class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        Map<String, Integer> scoresByWord = new HashMap();
        for (String word : words) {
            if (scoresByWord.containsKey(word)) continue;
            int result = 0;
            for (int i = 0; i < word.length(); i++) result += score[word.charAt(i) - 'a'];
            scoresByWord.put(word, result);
        }

        int[] counts = new int[26];
        for (char letter : letters) counts[letter - 'a'] += 1;

        int[] results = new int[1];
        helper(words, scoresByWord, counts, results, 0, 0);
        return results[0];
    }

    private void helper(String[] words, Map<String, Integer> scoresByWord, int[] counts, int[] results, int start, int result) {
        if (start >= words.length) return;

        for (int k = start; k < words.length; k++) {
            String word = words[k];
            boolean isOk = true;
            for (int i = 0; i < word.length(); i++) {
                if (--counts[word.charAt(i) - 'a'] < 0) {
                    for (int j = i; j >= 0; j--) counts[word.charAt(j) - 'a']++;
                    isOk = false;
                    break;
                }
            }
            if (!isOk) continue;
            int currentResult = result + scoresByWord.get(word);
            results[0] = Math.max(results[0], currentResult);
            helper(words, scoresByWord, counts, results, k + 1, currentResult);
            for (int i = 0; i < word.length(); i++) counts[word.charAt(i) - 'a']++;
        }
    }
}
