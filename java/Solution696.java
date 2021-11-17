class Solution {
    public int countBinarySubstrings(String s) {
        if (s.length() == 0) return 0;

        int result = 0;
        int counter = 1;
        int prevCounter = 0;
        char prevC = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == prevC) {
                prevC = c;
                counter++;
                continue;
            }

            if (prevCounter != 0) result += Math.min(prevCounter, counter);
            prevCounter = counter;
            counter = 1;
            prevC = c;
        }
        // trick -> do not forget compare the last one
        result += Math.min(prevCounter, counter);
        return result;
    }
}