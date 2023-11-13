public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        int count = 32;
        while (count > 0) {
            // trick -> there is no operation <<< in java
            result = result << 1;
            result += (n & 1);
            n >>>= 1;

            count--;
        }
        return result;
    }
}
