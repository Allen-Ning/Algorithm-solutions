class Solution {
    public int missingNumber(int[] nums) {
        int total = (0 + nums.length) * (nums.length + 1) / 2;
        int subTotal = 0; 
        for (int i = 0; i < nums.length; i++) {
            subTotal += nums[i];
        }
        return total - subTotal;
    }
}
