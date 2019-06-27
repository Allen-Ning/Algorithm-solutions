class Solution {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) return;
        int start = 0;
        int end = s.length -1;
        char temp = ' ';
        while (start < end) {
            temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
        return;
    }
}
