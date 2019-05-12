class Solution {
  public int[] productExceptSelf(int[] nums) {
    int[] leftSum = new int[nums.length];
    leftSum[0] = 1;

    for (int i = 1; i < nums.length; i++) {
      leftSum[i] = leftSum[i - 1] * nums[i - 1];
    }
    
    int right = 1;
    int[] total = new int[nums.length];
    for (int i = nums.length - 1; i >= 0; i--) {
      total[i] = leftSum[i] * right;
      right = right * nums[i];
    }
    return total;
  }
}
