class Solution {
    public int findPeakElement(int[] nums) {
        int l = -1;
        int h = nums.length;

        while (l + 1 != h) {
            int mid = l + (h - l) / 2;

            if (mid + 1 >= nums.length || nums[mid] > nums[mid + 1]) {
                h = mid;
            } else if (nums[mid] < nums[mid + 1]) {
                l = mid;
            }
        }
        return l + 1;
    }
}