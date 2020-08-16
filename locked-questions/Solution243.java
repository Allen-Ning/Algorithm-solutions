public class Solution {
    /**
     * @param words: a list of words
     * @param word1: a string
     * @param word2: a string
     * @return: the shortest distance between word1 and word2 in the list
     */
    public int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                index1 = i;
                if (index2 != -1) result = Math.min(result, Math.abs(index1 - index2));
            } else if (word.equals(word2)) {
                index2 = i;
                if (index1 != -1) result = Math.min(result, Math.abs(index1 - index2));
            }
        }
        return result;
    }
}