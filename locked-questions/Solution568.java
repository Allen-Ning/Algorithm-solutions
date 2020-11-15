public class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int result = 0;
        int weeks = days[0].length;
        int cities = days.length;
        int[][] dp = new int[weeks + 1][cities];

        for (int j = 0; j < dp[0].length; j++) {
            if (j > 0 && flights[0][j] == 0) dp[0][j] = Integer.MIN_VALUE;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = Integer.MIN_VALUE;
                for (int z = 0; z < flights.length; z++) {
                    if (z != j && flights[z][j] == 0) continue;

                    int holidays = days[j][i - 1] + dp[i - 1][z];
                    dp[i][j] = Math.max(dp[i][j], holidays);
                }
            }
        }

        for (int j = 0; j < dp[dp.length - 1].length; j++) result = Math.max(result, dp[dp.length - 1][j]);
        return result;
    }
}