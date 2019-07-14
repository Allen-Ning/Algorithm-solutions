class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[256];
        int maxCount = 0, start = 0, maxLength = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            maxCount = Math.max(maxCount, ++count[c]);
            while (end - start - maxCount + 1 > k) {
                maxCount = Math.max(maxCount, --count[s.charAt(start)]);
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
