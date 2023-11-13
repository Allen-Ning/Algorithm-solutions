class Solution {
    public int missingNumber(int[] nums) {
        int total = (0 + nums.length) * (nums.length + 1) / 2;
        int subTotal = 0;
        for (int i = 0; i < nums.length; i++) {
            subTotal += nums[i];
        }
        return total - subTotal;
    }

    public int missingNumber2(int[] nums) {
        /**
            trick ->
            use ^ XOR operator
            a ^ a = 0
            a ^ 0 = a
            b ^ a ^ a = b
            (a ^ b) ^ c = a ^ (b ^ c)

            check two cases:
            [3,0,1] n = 3
            [0,1,2] n = 3
         */
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i] ^ i;
        }
        return result;
    }
}
