class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = -1;
        int end = nums.length;

        while (start + 1 != end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return end;
    }
}