class Solution {
    public int majorityElement(int[] nums) {
        int target = nums[0];
        int result = 1;

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (result == 0) target = num;

            if (target == num) {
                result++;
            } else {
                result--;
            }
        }
        return target;
    }
}