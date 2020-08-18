public class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] letters = new int[26];
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            letters[index] += 1;
            if (letters[index] % 2 == 0) {
                result--;
            } else {
                result++;
            }
        }
        return result >= 2 ? false : true;
    }
}