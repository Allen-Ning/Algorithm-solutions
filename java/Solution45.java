class Solution {
    public int jump(int[] nums) {
        int step = 0;
        int prevEnd = nums[0];
        int newEnd = 0;

        for (int i = 1; i < nums.length; i++) {
            if (prevEnd >= nums.length - 1) return step + 1;

            newEnd = Math.max(newEnd, nums[i] + i);
            if (i < prevEnd) continue;

            prevEnd = newEnd;
            step++;
        }
        return step;
    }
}