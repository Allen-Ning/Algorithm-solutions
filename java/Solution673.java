class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int[] counter = new int[nums.length];
        int max = 1;
        Arrays.fill(dp, 1);
        Arrays.fill(counter, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    // trick -> add the counter to the existing longest increasing number of subsequece
                    if (dp[i] == dp[j] + 1) {
                        counter[i] += counter[j];
                    // trick -> reset counter if we can larger increasing number subsequence
                    } else if (dp[i] < dp[j] + 1){
                        counter[i] = counter[j];
                    }
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }

        int result = 0;
        // trick -> find all counter of the longest increasing number of subsequence
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == max) result += counter[i];
        }
        return result;
    }
}
