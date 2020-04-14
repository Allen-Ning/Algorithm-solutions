class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int[] counter = new int[K];
        int preSum = 0;
        for (int i = 0; i < A.length; i++) {
            preSum += A[i];
            int val = preSum % K;
            // trick -> this is for adjusting negative value to postive value after mod
            //          [-2, 6] K = 6
            //          preSum [-2, 4] K =6
            //          mod [-2, 4] -> [4, 4]
            //          -2 means the value need to +2 (to 0 ) or -4 to (-6) so that it can be divided by 6
            //          4  means the value need to +2 (to 6 ) or -4 to (0) so that it can be divivded by 6
            //          so that we can transfter -2 to 4 to get mod [-2, 4] -> [4, 4]
            if (val < 0) val += K;
            counter[val]++;
        }

        int result = 0;
        // trick -> this is for all the mod is 0, they can divide k themself
        result = counter[0];
        for (int i = 0; i < K; i++) {
            // trick -> this is C2,N
            result += (counter[i] * (counter[i] - 1)) / 2;
        }
        return result;
    }
}
