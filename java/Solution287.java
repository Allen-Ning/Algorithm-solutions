class Solution {
    public int findDuplicate(int[] nums) {
        // trick -> the idea is to move all nums to their corresponding
        //          index-based positions and then
        //          the duplicate number will try to drop the number to the an index
        //          which has been already occupied by the same number
        //                0  1  2  3  4  5
        //          e.g. [1, 2, 3, 4, 5, 1] -> index 0 is occupied by another 1
        //                0  1  2  3  4  5
        //          e.g. [3, 2, 3, 4, 5, 1] -> index 2 is occupied by another 3
        for (int i = 0; i < nums.length; i++) {
            int targetIndex = nums[i] - 1;

            while (targetIndex != i) {
                if (nums[i] == nums[targetIndex]) return nums[i];
                swop(nums, targetIndex, i);

                targetIndex = nums[i] - 1;
            }
        }
        return -1;
    }

    private void swop(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}