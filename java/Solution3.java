class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap();
        int result = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer index = map.get(c);

            // trick -> this is to avoid corner cases to stop j to move left 
            //          e.g. "abba"
            if (index != null && j <= index) j = index + 1;
            map.put(c, i);

            result = Math.max(result, i - j + 1);
        }
        return result;
    }
}