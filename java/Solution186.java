class Solution {
    public void reverseWords(char[] s) {
        // two step
        swop(s, 0, s.length - 1);

        // swop head and tail
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length; i++) {
            char c = s[i];
            if (c == ' ') {
                end = i;
                swop(s, start, end - 1);
                start = end + 1;
            }
        }
        swop(s, start, s.length - 1);
        // swop head and tail by each word
    }

    private void swop(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }
    }
}