class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int result = wordsDict.length;

        int index1 = -1;
        int index2 = -1;
        for (int i = 0; i < wordsDict.length; i++) {
            String word = wordsDict[i];
            if (word.equals(word1)) {
                index1 = i;
                if (index2 != -1) result = Math.min(result, index1 - index2);
            } else if (word.equals(word2)) {
                index2 = i;
                if (index1 != -1) result = Math.min(result, index2 - index1);
            }
        }
        return result;
    }
}