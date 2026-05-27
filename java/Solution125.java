class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        /**
         * the trick -> for some case, i could be be same as j, but we cannot allow i >
         * j because this will introduce over-searching
         *
         * There are 4 cases under 2 category
         * 1. both i, j can find valid chars case 1, and case 2, case 3
         * 2. both i, j cannot find valid chars case 4
         *
         * case1 -> i and j both can find equal valid chars
         * 0, 1, 2, 3
         * a c c a
         * i j
         * i
         * j
         *
         * case2 -> i and j both can find non-equal valid chars
         * 0, 1, 2, 3
         * a c d a
         * i j
         * i
         * j
         *
         * case3 -> when there is only one vaild char for both i and j
         * 0, 1, 2 , 3, 4
         * a ! b ! a
         * i j
         * i
         * j
         * case4 -> when there is no valid char for both i and j
         * 0, 1, 2 , 3, 4
         * a ! ! ! a
         * i j
         * i
         * j
         */
        while (i < j) {
            while (i < j && toValidChar(s.charAt(i)) == ' ')
                i++;

            while (i < j && toValidChar(s.charAt(j)) == ' ')
                j--;

            if (toValidChar(s.charAt(i)) != toValidChar(s.charAt(j)))
                return false;
            i++;
            j--;
        }
        return true;
    }

    private char toValidChar(char c) {
        if ('a' <= c && c <= 'z') {
            return c;
        } else if ('A' <= c && c <= 'Z') {
            return (char) ((c - 'A') + 'a');
        } else if ('0' <= c && c <= '9') {
            return c;
        } else {
            return ' ';
        }
    }
}