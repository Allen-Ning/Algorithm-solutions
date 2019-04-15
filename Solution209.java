class Solution {
  public int minSubArrayLen(int s, int[] nums) {
    int start = 0;
    int sum = 0;
    int minLength = Integer.MAX_VALUE;
    for (int end = 0; end < nums.length; end++) {
      sum += nums[end];
      while (sum >= s) {
        if (end - start + 1 < minLength) {
          minLength = end - start + 1;
        }
        sum -= nums[start];
        start += 1;
      }
    }
    return minLength == Integer.MAX_VALUE ? 0 : minLength;
  }
}

