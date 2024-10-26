class Solution {
    public int lengthOfLongestSubstring(String s) {
        int slow = 0;
        int fast = 0;
        Set<Character> set = new HashSet();
        int result = 0;

        while (fast < s.length()) {
            char end = s.charAt(fast);
            while (set.contains(end)) {
                char start = s.charAt(slow);
                set.remove(start);
                slow++;
            }

            set.add(end);
            result = Math.max(set.size(), result);
            fast++;
        }
        return result;
    }
}