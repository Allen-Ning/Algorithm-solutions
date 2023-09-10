class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int preSum = 0;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            right = total - preSum - num;
            if (preSum == right) return i;
            preSum += num;
        }
        return -1;
    }
}