import java.util.*;

class Solution {
    public int lengthOfLongestSubstring2(String s) {
        int maxLength     = 0;
        int repeatedIndex = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int startIndex = 0; startIndex < s.length(); startIndex++) {
            char currentChar = s.charAt(startIndex);
            if (map.containsKey(currentChar)) {
                maxLength     = Math.max(maxLength, startIndex - repeatedIndex);
                repeatedIndex = Math.max(map.get(currentChar) + 1, repeatedIndex);
            }
            map.put(currentChar, startIndex);
        }

        maxLength = Math.max(maxLength,  s.length() - repeatedIndex);
        return maxLength;
    }
}
