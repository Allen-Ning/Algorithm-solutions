class Solution {
  public int rob(int[] nums) {
    int[] r = new int[nums.length];
    int[] n = new int[nums.length];
    r[0] = nums[0];
    n[0] = 0;
    for (int i = 1; i < nums.length; i++) {
      r[i] = n[i -1] + nums[i];
      n[i] = r[i -1];
    }
    return Math.max(r[nums.length -1], n[nums.length -1]);
  }
}
