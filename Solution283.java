class Solution {
    public void moveZeroes(int[] nums) {
        // slow left not including slow
        int slow = 0;
        // fast searching area
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] == 0) {
                fast++;
                continue;
            };
            nums[slow] = nums[fast];
            slow++;
            fast++;
        }

        while (slow < nums.length) {
            nums[slow] = 0;
            slow++;
        }
    }
}
