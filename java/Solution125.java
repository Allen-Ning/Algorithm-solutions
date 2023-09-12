class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            char c1 = s.charAt(start);
            while (!alphanumeric(c1)) {
                start++;
                // trick -> when start reach the end, it means there no valid char
                if (start > end) return true;
                c1 = s.charAt(start);
            }

            char c2 = s.charAt(end);
            while (!alphanumeric(c2)) {
                end--;
                // trick -> when end reach the start, it means there is a valid char for start
                //          but no valid char for end
                if (start > end) return false;
                c2 = s.charAt(end);
            }

            if (toSmallerLetter(c1) != toSmallerLetter(c2)) return false;
            start++;
            end--;
        }
        return true;
    }

    private boolean alphanumeric(char c) {
        if ((c >= '0' && c <= '9') ||
            (c >= 'a' && c <= 'z') ||
            (c >= 'A' && c <= 'Z')
        ) return true;

        return false;
    }

    private char toSmallerLetter(char c) {
        if (c >= 'a' && c <= 'z') return c;
        if (c >= 'A' && c <= 'Z') return (char)(c - 'A' + 'a');

        return c;
    }
}