class Solution {
    public int triangularSum(int[] nums) {
        return helper(nums, nums.length);
    }

    private int helper(int[] nums, int size) {
        if (size == 0) return 0;
        if (size == 1) return nums[0];

        // e.g.
        // a[0] + a[1]
        // a[1] + a[2]
        // a[2] + a[3]
        // a[3] + a[4]
        for (int i = 0; i < size - 1; i++) {
            nums[i] = (nums[i] + nums[i + 1]) % 10;
        }
        return helper(nums, size - 1);
    }
}