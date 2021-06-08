class Solution {
    public int strongPasswordChecker(String s) {
        if (s.length() == 0) return 6;

        int required = getRequired(s);
        int[] info = getReplacedInfo(s);
        int replaced = info[0];
        int ones = info[1];
        int twoes = info[2];
        int threes = info[3];
        int length = s.length();
        if (length < 6) {
            return Math.max(6 - s.length(), Math.max(replaced, required));
        } else if (length >= 6 && length <= 20) {
            return Math.max(replaced, required);
        } else {
            int deleted = s.length() - 20;

            // trick -> this is the most tricky part
            //          three parts to be check
            //          1. num of removed chars
            //          2. num of required chars (can only be increased)
            //          3. num of repeated chars (potentially can be decreased) (by being replaced and removed)
            //          we can use trick to remove specific chars to reduce the num of repeated chars
            if (deleted <= ones) {
                replaced -= deleted;
            } else if (deleted <= (ones + 2 * twoes)) {
                replaced -= ones + (deleted - ones) / 2;
            } else if (deleted <= (ones + 2 * twoes + 3 * threes)) {
                replaced -= ones +  twoes + (deleted - ones - 2 * twoes) / 3;
            } else {
                // trick -> this means when all ones, twoes, threes are removed
                //          and then we can remove the other replaced
                //          e.g.  aaa aaa a ->
                //                aaa aa (after move all ones, twoes, and thress) ->
                //                aa (we remove the extra aaa if we can)
                replaced -= ones + twoes + threes + (deleted - ones - 2 * twoes - 3 * threes) / 3;
                if (replaced < 0) replaced = 0;
            }
            return deleted + Math.max(replaced, required);
        }
    }

    private int getRequired(String s) {
        int required = 3;
        boolean hasCapLetter = false;
        boolean hasSmallLetter = false;
        boolean hasNum = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!hasCapLetter && 'A' <= c && c <= 'Z') {
                hasCapLetter = true;
                required--;
            } else if (!hasSmallLetter && 'a' <= c && c <= 'z') {
                hasSmallLetter = true;
                required--;
            } else if (!hasNum && '1' <= c && c <= '9') {
                hasNum = true;
                required--;
            }
        }
        return required;
    }

    private int[] getReplacedInfo(String s) {
        int replaced = 0;
        int i = 1;
        int counter = 1;
        // trick -> ones, twoes, threes only care about the tail of repeating characters
        //                 r   r      r
        //          e.g. aaa aaa -> aaa aa
        //               replaced = 2
        //               one = 1
        //                 r   r        r
        //          e.g. aaa aaa a -> aaa aa
        //               replaced = 2
        //               two = 1
        //                 r   r
        //          e.g. aaa aaa aa -> aaa aa
        //               replaced = 2
        //               three = 1 -> aaa aa
        int ones = 0;
        int twoes = 0;
        int threes = 0;
        char pre = s.charAt(0);
        while (i < s.length()) {
            counter = 1;
            while (i < s.length() && s.charAt(i) == pre) {
                counter++;
                i++;
                if (counter % 3 == 0) replaced++;
            }

            if (counter / 3 > 0 && counter % 3 == 0) ones += 1;
            if (counter / 3 > 0 && counter % 3 == 1) twoes += 1;
            if (counter / 3 > 0 && counter % 3 == 2) threes += 1;

            if (i < s.length()) pre = s.charAt(i);
            i++;
        }
        return new int[] { replaced, ones, twoes, threes };
    }
}
