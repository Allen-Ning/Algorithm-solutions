class Solution {
    public int getMaxLen(int[] nums) {        
        int result = 0;
        int positive = 0;
        int negative = 0;
        if (nums[0] > 0) {
            positive = 1;
            result = 1;
        } else if (nums[0] < 0) {
            negative = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            int prevPostive = positive;
            int prevNegative = negative;
            if (num > 0) {
                positive = prevPostive + 1;
                negative = prevNegative == 0 ? 0 : prevNegative + 1;
            } else if (num < 0) {
                positive = prevNegative == 0 ? 0 : prevNegative + 1;
                negative = prevPostive + 1;
            } else {
                positive = 0;
                negative = 0;
            }
            result = Math.max(result, positive);
        }
        return result;
    }
}