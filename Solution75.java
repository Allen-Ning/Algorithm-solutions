class Solution {
  public void sortColors(int[] nums) {
    int i = 0, left = 0, right = nums.length - 1;
    while(i =< right) {
      if (nums[i] == 0) {
        swop(nums, left++, i++);
      } else if (nums[i] == 2) {
        swop(nums, right--, i);
      } else {
        i++;
      }
    }
  }

  private void swop(int[] nums, int index, int index2) {
    int temp = nums[index];
    nums[index] = nums[index2];
    nums[index2] = temp;
  }
}
