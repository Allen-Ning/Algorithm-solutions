class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int total = 0;
        for (int num : nums) total += num;

        if (total % 2 != 0) return false;
        int target = total / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            // this is the trick part -> have to loop from target value to num
            // as i decreases -> bigger i for dp[i] will not affect small i for dp[i]
            // eg. nums= [1, 2, 5]
            // if num = 1, please check the change of dp[i] -> dp[3] will be affcetd by dp[2] if using i increasing (i++)
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[target];
    }
}
