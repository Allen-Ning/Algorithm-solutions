class Solution {
    public int maximumProduct(int[] nums) {
        // there is another trick to find the max1, max2, max3, min1, min2
        // using O(n)
        // https://leetcode.com/problems/maximum-product-of-three-numbers/discuss/104729/Java-O(1)-space-O(n)-time-solution-beat-100
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        return Math.max(nums[start] * nums[start + 1] * nums[end], nums[end - 2] * nums[end - 1] * nums[end]);
    }
}
