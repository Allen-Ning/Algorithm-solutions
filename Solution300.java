class Solution {
  public int lengthOfLIS(int[] nums) {
    int[] tails = new int[nums.length];

    int size = 0;
    for (int num: nums) {
      int start = 0;
      int end = size;
      while (start < end) {
        int mid = start + (end - start) / 2;
        if (num <= tails[mid]) {
          end = mid;
        } else {
          start = mid + 1;
        }
      }
      tails[start] = num;
      if (start == size) {
        size++;
      }
    }
    return size;
  }
}
