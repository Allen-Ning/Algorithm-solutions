public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> map = new HashMap();
        int start = 0;
        int end = 0;
        int counter = 0;
        int result = 0;
        int k = 2;
        while (end < s.length()) {
            char c = s.charAt(end);
            int value = map.getOrDefault(c, 0);
            if (value++ == 0) counter++;
            map.put(c, value);

            if (end >= k) {
                while (counter > k) {
                    c = s.charAt(start++);
                    value = map.get(c);
                    if (--value == 0) counter--;
                    map.put(c, value);
                }
            }
            result = Math.max(result, end - start + 1);
            end++;
        }
        return result;
    }
}