class Solution {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int total = 0;
        for (int num : nums) total += num;
        int leftValue = 0;
        int rightValue = total - nums[0];
        if (leftValue == rightValue) return 0;

        for (int i = 1; i < nums.length; i++) {
            leftValue += nums[i - 1];
            rightValue -= nums[i];
            if (leftValue == rightValue) return i;
        }
        return -1;
    }
}
