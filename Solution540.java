class Solution {
  public int singleNonDuplicate(int[] nums) {
    int l = 0;
    int r = nums.length;
    while (l < r) {
      int mid = l + (r - l) / 2;
      int midPair = -1;
      if (mid % 2 == 0) {
        midPair = mid + 1;
      } else {
        midPair = mid - 1;
      }

      // this is for handling special case, [1] or [1, 1, 2]
      // // 0 1 2
      // 1 1 2

      // l = 0
      // r = 3
      // m = 1

      // l = 2
      // r = 3
      // m = 2 + (3 - 2)/2  = 2
      // m + 1 = 3 which is out of bound
      if (midPair > nums.length - 1) return nums[mid];

      if (nums[mid] != nums[midPair]) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return nums[l];
  }
}
