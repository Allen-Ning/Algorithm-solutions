class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lower = bsLower(nums, target);
        int upper = bsUpper(nums, target);
        if (lower < 0 || lower >= nums.length || nums[lower] != target) lower = -1;
        if (upper < 0 || upper >= nums.length || nums[upper] != target) upper = -1;
        return new int[] { lower,  upper};
    }

    private int bsLower(int[] nums, int target) {
        int l = -1;
        int h = nums.length;
        while (l + 1 != h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] < target) {
                l = mid;
            } else {
                h = mid;
            }
        }
        return h;
    }

    private int bsUpper(int[] nums, int target) {
        int l = -1;
        int h = nums.length;
        while (l + 1 != h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                h = mid;
            }
        }
        return l;
    }
}