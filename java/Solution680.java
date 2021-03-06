class Solution {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return isValid(s, start + 1, end) || isValid(s, start, end - 1);
            }
        }
        return true;
    }

    private boolean isValid(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
