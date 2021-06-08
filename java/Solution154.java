class Solution {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        return helper(nums, 0, nums.length - 1);
    }

    private int helper(int[] nums, int l, int r) {
        if (l == r) return nums[l];

        if (l == r - 1) return Math.min(nums[l], nums[r]);

        int mid = l + (r - l) / 2;
        int min1 = 0;
        // trick -> if this part is increasing, the min one is the left part
        //          cannot use nums[l] <= nums[mid]
        //          special case [1, 10, 10, 10, 10, 10] -> [10, 1, 10, 10, 10, 10]
        if (nums[l] < nums[mid]) {
            min1 = nums[l];
        } else {
            min1 = helper(nums, l, mid);
        }

        int min2 = 0;
         // trick -> if this part is increasing, the min one is the left part
        //          cannot use nums[l] <= nums[mid]
        //          special case [1, 10, 10, 10, 10, 10] -> [10, 1, 10, 10, 10, 10]
        if (nums[mid + 1] < nums[r]) {
            min2 = nums[mid + 1];
        } else {
            min2 = helper(nums, mid + 1, r);
        }

        return Math.min(min1, min2);
    }
}
