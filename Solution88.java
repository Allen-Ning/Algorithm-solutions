class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || nums2.length == 0) return;
        int count = 0;
        int i = 0;
        int j = 0;
        while (i < m && j < n && count < m + n) {
            int value1 = nums1[count];
            int value2 = nums2[j];
            if (value1 > value2) {
                helper(nums1, count);
                nums1[count] = value2;
                j++;
            } else {
                i++;
            }
            count++;
        }
        

        for (int start = j; start < nums2.length; start++) {
            nums1[count] = nums2[start];
            count++;
        }
        return;
    }
    
    private void helper(int[] nums, int i) {
        for (int start = nums.length - 1; start > i; start--) {
            nums[start] = nums[start - 1];
        }
    }
}
