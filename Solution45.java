class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            int maxReachIndex = Math.min(i + nums[i] + 1, nums.length);
            for (int j = i + 1; j < maxReachIndex; j++) {
                if (dp[j] < 0) continue; 
                min = Math.min(min, dp[j]);
            }

            dp[i] = (min == Integer.MAX_VALUE ? -1 : min + 1);
        }
        return dp[0];
    }
}
