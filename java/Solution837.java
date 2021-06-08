class Solution {

    public double new21Game(int N, int K, int W) {
        // eg.1
        // W = 6
        //  1 2 3 4 5 6  7
        // [x x x x x x] i
        // dp[1] = dp[0] * 1/W + 1 / W = (dp[0] + 1)  * 1 / W
        // dp[2] = dp[0] * 1/W + dp[1] * 1/W + 1 / W = (dp[0] + dp[1] + 1)  * 1 / W
        // dp[3] = dp[1] * 1/W + dp[2] * 1 /W + 1 / W = (dp[1] + dp[2] + 1)  * 1 / W
        // dp[4] = dp[1] * 1/W + dp[2] * 1 /W + dp[3] * 1/W + 1 / W = (dp[1] + dp[2] + dp[3] + 1)  * 1 / W
        // e.g. 2
        //  1 2 3 4 5 6  7
        // [x x x x x x] i
        // 1  2 3 4 5 6 7  8
        // x [x x x x x x] i
        if (K == 0) return 1;
        double[] dp = new double[N + 1];
        double w = W;
        // trick -> this is pretty smart, we use this way to dp[0] is for remove 1 from previous total
        //          e.g 2 after index i move from 6 to 7, we need to remove the base 1
        //                after index i from 7 to 8 we only need to get dp[8] = (dp[2] + ....dp[7]) / w
        //                we don't need base 1 anymore due to 7 larger than W
        dp[0] = 1;

        // trick -> this is pretty smart, we use this way to handle example1 by adding base 1
        //          total = 1 is for adding 1 such as (dp[i] + dp[i + 1] ... dp[x] + 1)
        double total = 1;
        for (int i = 1; i <= N; i++) {
            dp[i] = total / w;
            // trick -> we use k to split the example 1 and example 2 as above
            if (i < K) {
                total += dp[i];
            }
            // trick -> we use W to decide if we need to remove the element from sliding window
            if (i >= W) total -= dp[i - W];
        }

        double result = 0;
        for (int i = K; i <= N; i++) {
            result += dp[i];
        }
        return result;
    }
}
