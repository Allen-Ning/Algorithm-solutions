class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        // trick -> dp[i] indicates the sum of k nums subarrays from starting from index i;
        int[] dp = new int[nums.length - k + 1];
        int size = 0;
        int value = 0;
        int l = 0;
        int r = 0;

        int sum = 0;
        // trick -> sliding window to get dp[i]
        while (r < nums.length) {
            if (r <= k - 1) {
                sum += nums[r];
            } else {
                sum += (nums[r] - nums[l]);
                l++;
            }
            dp[l] = sum;
            r++;
        }

        // trick -> the maximium value of index dp[i] from left to right
        //          we would like to keep the smaller index in order to get the lexicographically smallest one
        int[] left = new int[dp.length];
        int max = dp[0];
        left[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > max) {
                left[i] = i;
                max = dp[i];
            } else {
                left[i] = left[i - 1];
            }
        }

        // trick -> the maximium value of index dp[i] from right to left
        //          we would like to keep the smaller index in order to get the lexicographically smallest one
        int[] right = new int[dp.length];
        max = dp[dp.length - 1];
        right[dp.length - 1] = dp.length - 1;
        for (int i = dp.length - 2; i >= 0; i--) {
            if (dp[i] >= max) {
                right[i] = i;
                max = dp[i];
            } else {
                right[i] = right[i + 1];
            }
        }

        int[] result = null;
        max = 0;
        // trick -> i is in range [k, nums.length - 2k]
        //          be careful we need to deal with i - k and i + k index to avoid overlap
        //          i will be picked based on nums index rather than dp index to be more clear
        for (int i = k; i <= nums.length - 2 * k; i++) {
            int current = dp[left[i - k]] + dp[right[i + k]] + dp[i];
            if ( current > max) {
                result = new int[] { left[i - k], i, right[i + k]};
                max = current;
            }
        }
        return result;
    }
}
