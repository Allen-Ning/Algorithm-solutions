class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);

        int result = 1;
        int start = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - start <= k) continue;
            start = nums[i];
            result++;
        }
        return result;
    }
}