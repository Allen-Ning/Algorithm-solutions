class Solution {
    public int firstUniqChar(String s) {
        int[] letters = new int[26];
        for (char c : s.toCharArray()) letters[c - 'a'] += 1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (letters[c - 'a'] == 1) return i;
        }
        return -1;
    }
}