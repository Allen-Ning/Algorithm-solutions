class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums.length <= 2) return nums.length;
    
    int result = 2;
    for (int i = 2; i < nums.length; i++) {
      if (nums[i] == nums[result - 2]) {
        continue;
      } else {
        nums[result] = nums[i];
        result++;
      }
    }
    return result;
  }
}
