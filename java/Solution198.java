class Solution {
    public int rob(int[] nums) {
        int result = nums[0];
        int rob = nums[0];
        int skip = 0;
        for (int i = 1; i < nums.length; i++) {
            int preRob = rob;
            int preSkip = skip;

            rob = preSkip + nums[i];
            // trick -> you could keep skipping multiple houses
            // e.g. 1. steal the first house and then
            // 2. skip the second one and the third one
            // 3. steal the last house.
            // [ 2, 1, 1, 2]
            // r 2 1 3 4
            // s 0 2 2 3
            skip = Math.max(preRob, preSkip);

            result = Math.max(Math.max(rob, skip), result);
        }
        return result;
    }
}