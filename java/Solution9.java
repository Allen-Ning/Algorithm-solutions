class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        if (x % 10 == 0) return false;

        int total = x;
        int half = 0;
        while (total > half) {
            half = half * 10 + total % 10;
            total = total / 10;
        }
        return total == half || total == half / 10;
    }
}