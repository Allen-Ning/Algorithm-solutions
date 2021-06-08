// https://blog.csdn.net/fuxuemingzhu/article/details/82982325

class Solution {
  public int rob(int[] nums) {
    if (nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];

    return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
  }

  private int helper(int[] nums, int start, int end) {
    int newLength = nums.length - 1;
    int[] rob = new int[newLength];
    int[] notRob = new int[newLength];

    rob[0] = nums[start];
    notRob[0] = 0;
    for (int i = 1; i < rob.length; i++) {
      rob[i] = notRob[i - 1] + nums[start + i];
      notRob[i] = Math.max(rob[i - 1], notRob[i - 1]);
    }
    return Math.max(rob[newLength - 1], notRob[newLength - 1]);
  }
}
