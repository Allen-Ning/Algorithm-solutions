class Solution {
    public int removePalindromeSub(String s) {
        if (s.length() == 0) return 0;
        if (isPalindrome(s)) return 1;
        // trick -> only contains "a" and "b"
        //          first step to remove all a
        //          second step to remove all b
        return 2;
    }

    private boolean isPalindrome(String s) {
        int l = 0;
        int h = s.length() - 1;
        while (l < h) {
            if (s.charAt(l) != s.charAt(h)) return false;
            l++;
            h--;
        }
        return true;
    }
}
