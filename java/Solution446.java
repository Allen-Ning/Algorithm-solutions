class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        HashMap<Long, List<Integer>> map = new HashMap();
        for (int i = 0; i < A.length; i++) {
            long key = (long) A[i];
            List<Integer> list = map.getOrDefault(key, new ArrayList());
            list.add(i);
            map.put(key, list);
        }

        // dp indicates the postion of B, C in (A, B, C)
        long[][] dp = new long[A.length][A.length];
        int result = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = i + 1; j < dp.length; j++) {
                // trick -> A[i] - lookup = A[j] - A[i];
                long lookUp = 2 * (long) A[i] - (long) A[j];
                List<Integer> indexes = map.get(lookUp);
                if (indexes != null) {
                    for (int index : indexes) {
                        if (index >= i) break;
                        dp[i][j] += dp[index][i] + 1;
                    }
                }
                result += dp[i][j];
            }
        }
        return result;
    }
}