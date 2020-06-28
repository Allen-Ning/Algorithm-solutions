class Solution {
    // trick -> hard to implement
    public int countDigitOne(int n) {
        if (n < 0) return 0;
        String str = String.valueOf(n);
        long counter = 0;
        // 0 1 2 3 4 5 6
        // x x x 3 x x x
        //             right
        for (int i = str.length() - 1; i >= 0; i--) {
            int right = str.length() - 1 - i;
            char c = str.charAt(i);
            counter += (n / (int) Math.pow(10, right + 1)) * Math.pow(10, right);
            if (c == '0') {
                counter += 0;
            } else if (c == '1') {
                // trick -> this is for calculating the remaining value of n
                //          e.g. when i = 6, right = 0, value = 1 (special case)
                //               when i = 3, right = 3, remaining value (n % (long) Math.pow(10, right)) = 456
                //               and range will be [0 ~ 456] so that value is 457
                long value = (right == 0) ? 1 : n % (int) Math.pow(10, right) + 1;
                counter += 1 * 1 * value;
            } else {
                counter += 1 * 1 * Math.pow(10, right);
            }
        }
        return (int) counter;
    }
}
