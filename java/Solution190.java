public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int temp = (n >>> (31 - i)) & 1;
            result += (temp << i); 
        }
        return result;
    }
}
