class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) return false;

        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            letters[c - 'a'] += 1;
        }

        int counter = 0;
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] % 2 != 0) counter++;
        }

        return counter <= k;
    }
}
