class Solution {
    public int longestSubstring(String s, int k) {
        return helper(s, k);
    }

    private int helper(String s, int k) {
        if (s == null) return 0;
        if (s.length() == 1) {
            return s.length() >= k ? 1 : 0;
        }

        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        // special case -> this will hanle full string no seperate case
        boolean isBreak = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) < k) {
                isBreak = true;
            }
        }
        if (!isBreak) return s.length();

        int max = 0;
        int start = 0;
        int end = 0;
        // trick -> use less than k character as seperator
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.get(c) < k) {
                max = Math.max(max, helper(s.substring(start, end), k));
                start = end + 1;
            }
            end++;
        }
        if (start < s.length()) max = Math.max(max, helper(s.substring(start), k));
        return max;
    }
}
