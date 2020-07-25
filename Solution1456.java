class Solution {
    public int maxVowels(String s, int k) {
        int l = 0;
        int r = 0;
        int counter = 0;
        int max = 0;
        while (r < s.length()) {
            if (isVowel(s.charAt(r))) counter++;
            if (r >= k) {
                if (isVowel(s.charAt(l))) counter--;
                l++;
            }
            max = Math.max(max, counter);
            r++;
        }
        return max;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'; 
    }
}
