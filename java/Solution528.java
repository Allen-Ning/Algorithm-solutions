class Solution {
    int[] preSum;
    Random r;
    public Solution(int[] w) {
        preSum = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            if (i == 0) {
                preSum[i] = w[i];
                continue;
            } 
            this.preSum[i] = preSum[i - 1] + w[i];
        }
        r = new Random();
    }

    public int pickIndex() {
        int maxValue = preSum[preSum.length - 1];
        int target = r.nextInt(maxValue) + 1;
        return helper(preSum, 0, preSum.length, target);
    }

    private int helper(int[] preSum, int l, int r, int target) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (preSum[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
