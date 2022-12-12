class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) letters[s.charAt(i) - 'a'] += 1;

        int[] targetLetters = new int[26];
        for (int i = 0; i < target.length(); i++) targetLetters[target.charAt(i) - 'a'] += 1;

        int result = s.length();
        for (int i = 0; i < targetLetters.length; i++) {
            if (targetLetters[i] == 0) continue;

            result = Math.min(result, letters[i] / targetLetters[i]);
        }
        return result;
    }
}