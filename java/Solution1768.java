class Solution {
    public String mergeAlternately(String word1, String word2) {
        // two pointers
        StringBuilder sb = new StringBuilder();
        int index1 = 0;
        int index2 = 0;
        boolean shouldFlip = true;
        while (index1 < word1.length() && index2 < word2.length()) {
            sb.append(shouldFlip ? word1.charAt(index1++) : word2.charAt(index2++));
            shouldFlip = !shouldFlip;
        }

        while (index1 < word1.length()) sb.append(word1.charAt(index1++));
        while (index2 < word2.length()) sb.append(word2.charAt(index2++));
        return sb.toString();
    }
}