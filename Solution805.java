class Solution {
    public boolean splitArraySameAverage(int[] A) {
        if (A == null || A.length <= 1) return false;
        Arrays.sort(A);

        int total = 0;
        for (int value : A) total += value;
        double average = (double) total / A.length;

        boolean[][] dp = new boolean[total / 2 + 1][A.length + 1];
        dp[0][0] = true;
        // trick -> questions similiar to backpack problems
        for (int i = 0; i < A.length; i++) {
            // trick -> we need to reverse way checking to avoid new dp update the old dp
            //          which will be causing wrong answer
            //          e.g a0 b0 c0 d0 (old dp)
            //              a1 b1 c1 d1 (new dp)
            //                 <----
            //          d1 will be determined by c0
            //          c1 will be determined by b0
            //          b1 will be determined by a0
            //          so that we can use one dp to replace two dp
            //          cos we get the new dp by overwriting the value from bigger to smaller
            //
            //          e.g a0 b0 c0 d0 (old dp)
            //              a1 b1 c1 d1 (new dp)
            //                ------>
            //          b1 will be based on a0
            //          c1 will be based on b0
            //          d1 will be based on c0
            //          we have to use two dp
            //          cos we get the new dp by overwrting value from smaller to bigger
            for (int sum = total / 2; sum >= 0; sum--) {
                // trick -> we only need to check num is smaller than the current ik
                for (int num = 1; num <= i + 1; num++) {
                    if (sum - A[i] < 0) continue;

                    dp[sum][num] = dp[sum][num] || dp[sum - A[i]][num - 1];
                    if (dp[sum][num] && (double) sum / num == average) return true;
                }
            }
        }
        return false;
    }
}
