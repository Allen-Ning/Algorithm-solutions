class Solution {
    int[] nums;
    Random random;
    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int pick(int target) {
        int index = -1;
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) continue;

            counter++;
            if (random.nextInt(counter) == 0) index = i;
        }
        return index;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
