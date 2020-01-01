class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums) max = Math.max(max, num);

        // trick change to dp question like lc 198 first and then do it 
        int[] result = new int[max + 1];
        for (int num : nums) result[num] += num;

        int[] dp = new int[result.length];
        dp[0] = result[0];
        if (result.length > 1) dp[1] = Math.max(result[1], dp[0]);
        for (int i = 2; i < result.length; i++) {
            dp[i] = Math.max(dp[i - 2] + result[i], dp[i - 1]);
        }
        return dp[result.length - 1];
    }
}
