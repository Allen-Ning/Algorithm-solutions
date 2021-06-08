class Solution {
    public boolean arrayStringsAreEqual(String[] words1, String[] words2) {
        if (words1 == null && words2 == null) return true;
        if (words1 == null || words2 == null) return false;

        int subIndex1 = 0;
        int index1 = 0;
        int subIndex2 = 0;
        int index2 = 0;

        while (index1 < words1.length && index2 < words2.length) {
            String word1 = words1[index1];
            String word2 = words2[index2];

            if (word1.charAt(subIndex1) != word2.charAt(subIndex2)) return false;
            subIndex1++;
            subIndex2++;

            if (subIndex1 == word1.length()) {
                subIndex1 = 0;
                index1++;
            }

            if (subIndex2 == word2.length()) {
                subIndex2 = 0;
                index2++;
            }
        }

        if (index1 < words1.length) return false;
        if (index2 < words2.length) return false;
        return true;
    }
}