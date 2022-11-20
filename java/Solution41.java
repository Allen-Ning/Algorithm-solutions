class Solution {
    //  0   1    2  3
    // [3,  4,  -1, 1]
    // [-1, 4,  3,  1]
    // [-1, 1,  3,  4]
    // [1,  -1, 3,  4]
    public int firstMissingPositive(int[] nums) {
        // trick -> sort value by index - one by one util it cannot find
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (num - 1 >= 0 &&
                   num - 1 < nums.length &&
                   nums[num - 1] != num) {
                swop(nums, num - 1, i);
                num = nums[i];
            }
        }

        int result = 1;
        for (int i = 0; i < nums.length; i++) {
            if (result != nums[i]) return result;
            result++;
        }
        return result;
    }

    private void swop(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
