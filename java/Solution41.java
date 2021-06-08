class Solution {
    //  0   1    2  3
    // [3,  4,  -1, 1]
    // [-1, 4,  3,  1]
    // [-1, 1,  3,  4]
    // [1,  -1, 3,  4]
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] - 1 < nums.length && nums[nums[i] - 1] != nums[i]) {
                swop(nums, nums[i] - 1, i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private void swop(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i]  = nums[j];
        nums[j]  = temp;
    }
}
