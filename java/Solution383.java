class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[26];
        for (char c : magazine.toCharArray()) {
            letters[c - 'a'] += 1;
        }

        for (char c : ransomNote.toCharArray()) {
            letters[c - 'a'] -= 1;
            if (letters[c - 'a'] < 0) return false;
        }
        return true;
    }
}