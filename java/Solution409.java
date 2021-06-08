class Solution {
    public int longestPalindrome(String s) {
        int[] letters = new int[256];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i)]++;
        }

        int result = 0;
        int max = 0;
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] % 2 == 0) {
                result += letters[i];
            } else if (letters[i] > 0){
                result += (letters[i] - 1);
                max = 1;
            }
        }
        result += max;
        return result;
    }
}
