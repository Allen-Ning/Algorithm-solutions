class Solution {
    public void sortColors(int[] nums) {
        int p1 = 0; 
        int p2 = nums.length - 1;
        int i = 0;
        while (i <= p2) {
            int num = nums[i];
            if (num == 0) {
                swop(nums, p1++, i++);
            } else if (num == 2) {
                // trick -> after swop with p2, double check the current i
                swop(nums, p2--, i);
            } else {
                i++;
            }
        }
    }

    private void swop(int[] nums, int p1, int p2) {
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }
}