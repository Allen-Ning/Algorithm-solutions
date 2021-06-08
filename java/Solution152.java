class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // solution trick :
        // maxArray means max value from index 0 to current index (including current index)
        // minArray means min value from index 0 to current index (including current index)
        int[] maxArray = new int[nums.length];
        int[] minArray = new int[nums.length];

        int result = Integer.MIN_VALUE;
        maxArray[0] = nums[0];
        minArray[0] = nums[0];
        result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            maxArray[i] = Math.max(num, Math.max(num * maxArray[i - 1], num * minArray[i - 1]));
            minArray[i] = Math.min(num, Math.min(num * maxArray[i - 1], num * minArray[i - 1]));
            result = Math.max(maxArray[i], result);
        }
        return result;
    }
}
