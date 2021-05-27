public class Solution {
    public void wiggleSort(int[] nums) {
        // TODO not the best solution
        Arrays.sort(nums);
        // trick -> e.g.
        //  0  1  2  3  4  5  6  7
        // [1, 2, 3, 4, 5, 6, 7, 8]
        //  1  3  2  5  4  7  6  8
        for (int i = 1; i < nums.length; i += 2) {
            if (i + 1 > nums.length - 1) break;
            swop(nums, i, i + 1);
        }
    }

    private void swop(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}