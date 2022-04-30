class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = -1;
        int h = nums.length;

        while (l + 1 != h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) {
                h = mid;
            } else {
                l = mid;
            }
        }
        return h;
    }
}