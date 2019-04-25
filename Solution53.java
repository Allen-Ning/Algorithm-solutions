class Solution {
  public int maxSubArray(int[] nums) {
    if(nums.length == 0) return 0;
    if(nums.length ==1) return nums[0];
    int[] sum = new int[nums.length];
    sum[0] = nums[0];
    int maxSum = sum[0];
    for (int i = 1; i < nums.length; i++) {
      sum[i] = Math.max(nums[i], nums[i] + sum[i - 1]);
      if (sum[i] > maxSum) maxSum = sum[i];
    }
    return maxSum;
  }
}
