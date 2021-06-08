class Solution {
    public int minOperations(int[] nums) {
        // trick -> this is greedy approach to count the high bits + all ones
        // trick -> higBits means * 2 for all nums
        int higBits = 0;
        // trick -> the sum of 1 in binary
        int counterOne = 0;
        for (int num : nums) {
            int bitsCounter = 0;
            while (num > 0) {
                if ((num & 1) == 1) counterOne++;
                // trick -> we needs assign num = num >> 1
                num = num >> 1;
                bitsCounter++;
            }
            if (bitsCounter >= 1) bitsCounter -= 1;
            higBits = Math.max(higBits, bitsCounter);
        }
        return higBits + counterOne;
    }
}
