class Solution {
  public int[] productExceptSelf(int[] nums) {
    int[] sum = new int[nums.length];
    sum[0] = 1;

    for (int i = 1; i < nums.length; i++) {
      sum[i] = sum[i - 1] * nums[i - 1];
    }
    
    int right = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      sum[i] = sum[i] * right;
      right = right * nums[i];
    }
    return sum;
  }
}
