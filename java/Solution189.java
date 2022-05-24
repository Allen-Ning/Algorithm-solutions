class Solution {
    public void rotate(int[] nums, int k) {
        // trick -> if move nums.length step, it will be back to the original state
        k = k % nums.length;
        // e.g
        // [1, 2, 3, 4, 5, 6, 7]
        // [7, 6, 5, 4, 3, 2, 1]
        // [7, 6, 5 | 4, 3, 2, 1]
        // [5, 6, 7 | 1, 2, 3, 4]
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int nums[], int start, int end) {
        int l = start;
        int h = end;
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}