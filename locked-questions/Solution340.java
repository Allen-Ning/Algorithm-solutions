public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int start = 0;
        int end = 0;
        int total = 0;
        int[] letters = new int[256];
        int result = 0;
        int length = s.length();
        while (end < length) {
            if (letters[s.charAt(end)]++ == 0) total += 1;

            while (end >= k && total > k && start <= end) {
                if (--letters[s.charAt(start++)] == 0) total -= 1;
            }
            result = Math.max(result, end - start + 1);
            end++;
        }
        return result;
    }
}