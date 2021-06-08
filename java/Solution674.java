class Solution {
  public int findLengthOfLCIS(int[] nums) {
    if (nums == null || nums.length == 0) return 0; 
    int counter = 1;
    int temp = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] < nums[i]) {
        temp++;
      } else {
        temp = 1;
      }
      counter = Math.max(counter, temp);
    }
    return counter;
  }
}
