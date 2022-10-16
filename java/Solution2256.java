class Solution {
    public int minimumAverageDifference(int[] nums) {
        long max = Integer.MAX_VALUE;
        int result = 0;
        long[] preSum = new long[nums.length];
        long total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            preSum[i] = total;
        }

        for (int i = 0; i < nums.length; i++) {
            long part1 = preSum[i] / (i + 1);
            long part2 = 0;

            if (i != nums.length - 1) part2 = (preSum[nums.length - 1] - preSum[i]) / (nums.length - i - 1);

            if (Math.abs(part1 - part2) < max) {
                result = i;
                max = Math.abs(part1 - part2);
            }
        }
        return result;
    }
}