class Solution {
    public void sortColors(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int t = 0;
        int pivot = 1;
        while (t <= j) {
            if (nums[t] < pivot) {
                swop(nums, t, i);
                i++;
                t++;
            } else if (nums[t] > pivot) {
                swop(nums, t, j);
                j--;
            } else {
                t++;
            }
        }
    }

    private void swop(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}