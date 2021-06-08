class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> results = new ArrayList();
        for (int i = 0; i <= 9; i++) helper(N, K, results, i, i, 1);

        int[] nums = new int[results.size()];
        for (int i = 0; i < results.size(); i++) nums[i] = results.get(i);
        return nums;
    }

    private void helper(int N, int K, List<Integer> results, int value, int current, int counter) {
        if (counter == N) {
            results.add(value);
            return;
        }
        if (value == 0) return;

        if (current - K >= 0) helper(N, K, results, value * 10 + current - K, current - K, counter + 1);
        // trick -> if current - K == current + K, we can skip the branch to avoid duplicate results
        if (current - K == current + K) return;
        if (current + K <= 9) helper(N, K, results, value * 10 + current + K, current + K, counter + 1);
    }
}
