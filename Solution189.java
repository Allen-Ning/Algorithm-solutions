// [1,2,3,4,5,6,7] 
// [7, 6, 5, 4, 3, 2, 1] 
// [7, 6, 5, 4, 3, 2, 1]
// [5, 6, 7, 4, 3, 2, 1]
// [5, 6, 7, 1, 2, 3, 4]
// please notice k %= nums.length
class Solution {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k == 0) return;
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length -1);
        return;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
