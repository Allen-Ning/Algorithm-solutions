class Solution {
    public void sortColors(int[] nums) {
        /**
         * trick -> define 3 pointers: i, j, z
         * 1. index < i, 0
         * 2. index > j, 2
         * 3. in-between [i, j], 1
         */
        int i = 0;
        int j = nums.length - 1;
        int z = 0;
        while (z <= j) {
            int num = nums[z];
            if (num == 0) {
                swop(nums, z, i);
                i++;
                z++;
            } else if (num == 2) {
                swop(nums, z, j);
                j--;
            } else {
                z++;
            }
        }
    }

    private void swop(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}