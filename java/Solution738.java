class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] nums = String.valueOf(N).toCharArray();
        int position = nums.length;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i - 1] > nums[i]) {
                nums[i - 1] -= 1;
                position = i;
            }
        }
        if (position == nums.length) return N;
        while (position < nums.length) nums[position++] = '9';

        return Integer.valueOf(new String(nums));
    }
}
