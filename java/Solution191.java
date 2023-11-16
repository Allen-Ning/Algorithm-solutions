public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        /**
            loop
            >>> right operation and count 1
         */
        int result = 0;
        while (n != 0) {
            int bitValue = n & 1;
            if (bitValue == 1) result++;
            n >>>= 1;
        }
        return result;
    }
}