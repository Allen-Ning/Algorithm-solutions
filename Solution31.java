// 1.  From the tail to find the first digital which drop
//  example: 12 4321

//首先我们找到从尾部到头部第一个下降的digit. 在例子中是：2

//2. 把从右到左第一个比dropindex大的元素换过来。

//3. 把dropindex右边的的序列反序

//4. 如果1步找不到这个index ，则不需要执行第二步。


class Solution {
  public void nextPermutation(int[] nums) {
    if (nums.length == 0 || nums.length == 1) return;
    int i = nums.length - 2;
    while(i >= 0 && nums[i] >= nums[i + 1]) i -= 1;

    if (i > 0) {
      int j = nums.length - 1;
      while ( nums[j] <= nums[i]) {
        j -= 1;
      }
      swop(nums, i, j);
    }
    reverse(nums, i+1 , nums.length - 1);
  }

  private void swop(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  private void reverse(int[] nums, int i, int j) {
    while (i < j) {
      swop(nums, i++, j--);
    }
  }
}
