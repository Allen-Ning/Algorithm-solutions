class Solution {
    public int totalHammingDistance(int[] nums) {
        // 0100 
        // 1110
        // 0010
        int result = 0; 
        for (int i = 0; i <= 31; i++) {
            int mask = 1 << i;
            int ones = 0;
            int zeros = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & mask) >> i == 0) zeros++;
                if ((nums[j] & mask) >> i == 1) ones++;
            }
            result += ones * zeros;
        }
        return result;
    }
}
