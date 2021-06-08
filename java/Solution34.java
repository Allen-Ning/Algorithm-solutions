class Solution {
  public int[] searchRange(int[] nums, int target) {
    if (nums.length == 0 ) return new int[] {-1, -1};
    int first = findFirst(nums, target);
    int last = findLast(nums, target);
    return new int[] {first, last};
  }

  private int findFirst(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    while( low < high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] < target) {
        low = mid + 1;
      } else {
         high = mid;
      }
    }
    return nums[low] == target ? low : -1;
  }

  private int findLast(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    while( low < high) {
      int mid = low + (high - low) / 2 + 1;
      if (nums[mid] > target) {
        high = mid - 1;
      } else {
        low = mid;
      }
    }
    return nums[low] == target ? low : -1;
  }

}
