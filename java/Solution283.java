class Solution {
    public void moveZeroes(int[] nums) {
        // two pointer approach
        // p1 indicates the current non-zero areas not including p1
        // p2 is the scaning area, p2 will alawys stop at non-zero num

        int p1 = 0;
        for (int p2 = 0; p2 < nums.length; p2++) {
            if (nums[p2] == 0) continue;

            nums[p1++] = nums[p2];
        }

        while (p1 < nums.length) nums[p1++] = 0;
    }
}