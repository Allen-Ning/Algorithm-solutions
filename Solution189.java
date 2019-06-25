class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return;
        int temp = 0;
        int i = 1;
        while(i <= k) {
            temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
            i++;
        }
        return;
    }
}
