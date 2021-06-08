class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        if (days == null || days.length == 0 || costs == null || costs.length == 0) return 0;
        Set<Integer> set = new HashSet();
        int max = 0;
        for (int day : days) {
            set.add(day);
            max = Math.max(max, day);
        }

        int[] dp = new int[max + 1];
        dp[0] = 0;

        int last = 0;
        for (int i = 1; i < dp.length; i++) {
            if (!set.contains(i)) {
                dp[i] = last;
                continue;
            }

            dp[i] = dp[i - 1] + costs[0];
            dp[i] = i >= 7 ?
                Math.min(dp[i], dp[i - 7] + costs[1]) :
                Math.min(dp[i], dp[0] + costs[1]);
            dp[i] = i >= 30 ?
                Math.min(dp[i], dp[i - 30] + costs[2]) :
                Math.min(dp[i], dp[0] + costs[2]);
            last = dp[i];
        }
        return dp[dp.length - 1];
    }
}
