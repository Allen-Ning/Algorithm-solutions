class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] results = new int[nums.length];
        results[0] = 1;
        // trick -> using int[] results to record
        //          from left to right multiply not including the current value
        for (int i = 1; i < nums.length; i++) {
            results[i] = results[i - 1] * nums[i - 1];
        }

        int right = 1;
        // trick -> using variable right to record
        //          from right to left multiply not including the current value
        for (int i = nums.length - 1; i >= 0; i--) {
            results[i] *= right;
            right *= nums[i];
        }
        return results;
    }
}