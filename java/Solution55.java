class Solution {
    public boolean canJump(int[] nums) {
        /**
            the idea is to caculate the curernt max ->
            1. loop
            2. if i <= currentMax -> keep going
            3. otherwise, stop
         */
        int currentMax = 0;
        for (int i = 0; i <= Math.min(currentMax, nums.length - 1); i++) {
            currentMax = Math.max(nums[i] + i, currentMax);

            if (currentMax >= nums.length - 1) return true;
        }
        return false;
    }
}
