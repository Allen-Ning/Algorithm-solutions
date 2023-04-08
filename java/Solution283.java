class Solution {
    public void moveZeroes(int[] nums) {
        // left -> non-zero not including the current index
        // right -> scan area
        int left = 0;
        int right = 0;
        for (;right < nums.length; right++) {
            int num = nums[right];
            if (num == 0) continue;

            nums[left++] = num;
        }

        while (left < nums.length) nums[left++] = 0;
    }
}