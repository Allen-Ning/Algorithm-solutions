class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int result = max;
        for (int i = 1; i < nums.length; i++) {
            // trick -> max means the maximum value -> all subarrays ending with index i
            max = Math.max(nums[i], nums[i] + max);
            result = Math.max(result, max);
        }
        return result;
    }
}