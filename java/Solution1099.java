class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);

        int start = 0;
        int end = nums.length - 1;
        int result = -1;
        while (start < end) {
            if (nums[start] + nums[end] < k) {
                result = Math.max(result, nums[start] + nums[end]);
                start++;
            } else {
                end--;
            }
        }
        return result;
    }
}