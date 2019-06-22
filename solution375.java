
// [1, 2, 3]
// select: 1 -> 3; cost: 1 + 3; pick 2
// select: 1 -> 2; cost: 1 + 2; pick 3
// select: 2 -> 1 or 3; cost: 2; pick 1 or 3
// select: 3 -> 1; cost: 3 + 1; pick 2
// select: 3 -> 2; cost: 3 + 2; pick 1
class Solution {
    int[][] dp;

    public int getMoneyAmount(int n) {
        this.dp = new int[n + 1][n + 1];
        return helper(1, n);
    }
    
    private int helper(int start, int end) {
        if (start >= end) {
            return 0;
        }

        if (dp[start][end] != 0) return dp[start][end];
        
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            int result = i + Math.max(helper(start, i - 1), helper(i+1, end));
            min = Math.min(result, min);
        }
        dp[start][end] = min;
        return min;
    }

}
