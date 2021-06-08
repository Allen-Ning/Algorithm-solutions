class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);

        int result = 0;
        for (int i = nums.length - 1; i >= 2; i--) {
            int l = 0, h = i - 1;

            while (l < h) {
              if (nums[l] + nums[h] > nums[i]) {
                result += h - l;
                h--;
              } else {
                l++;
              }
            }
      }
      return result;
    }
}
