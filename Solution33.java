class Solution {
  public int search(int[] nums, int target) {
    int low = 0;
    int high = nums.length;
    while(low < high) {
      int mid = low + (high - low) /2;
      if (nums[low] < nums[mid]) {
        if (target == nums[mid]) return mid;
        if (target < nums[mid] && target >= nums[low]) {
          high = mid;
        } else {
          low = mid + 1;
        }
      } else {
        if (target == nums[mid]) return mid;
        if(nums[mid] < target && target <= nums[high -1]) {
          low = mid + 1;
        } else {
          high = mid;
        }
      }
    }
    return (low < nums.length && nums[low] == target) ? low : -1;
  }
}
