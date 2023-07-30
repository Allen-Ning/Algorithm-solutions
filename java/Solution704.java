class Solution {
    public int search(int[] nums, int target) {
        int l = -1;
        int h = nums.length;

        while (l + 1 != h) {
            int m = l + (h - l) / 2;
            if (nums[m] <= target) {
                l = m;
            } else {
                h = m;
            }
        }

        // trick -> l could be -1, which is causing out of IndexOutOfBounds error
        return (l >= 0 && nums[l] == target) ? l : -1;
    }
}