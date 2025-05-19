class Solution {
    /**
        trick -> The reason sliding window works so efficiently (O(n) time) is precisely because of this monotonicity

        why sliding window fails for this problem:
        Consider: nums = [1, -1, 1, 2], k = 3
        Let's trace what happens with a sliding window approach:

        1. Start with window [1], sum = 1 < k, so expand
        2. Window [1, -1], sum = 0 < k, so expand
        3. Window [1, -1, 1], sum = 1 < k, so expand
        4. Window [1, -1, 1, 2], sum = 3 = k, count = 1

        The sliding window found only 1 subarray with sum = 3: [1, -1, 1, 2].
        But there are actually 2 valid subarrays:

        * [1, -1, 1, 2] (the entire array)
        * [1, 2] (the subarray starting at index 2)

        The sliding window misses the [1, 2] subarray because it never considers "skipping" the negative element.
        The algorithm can't easily backtrack to find all valid combinations because the presence of negative numbers breaks the monotonic property that sliding window relies on.

        With negative numbers, increasing the window size might decrease the sum and decreasing the window size might increase the sum, which prevents us from making reliable decisions about when to expand or contract the window.
     */


    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        int preSum = 0;
        int result = 0;

        // trick -> this is to add 1 to result when preSum == k
        map.put(0, 1);
        for (int num : nums) {
            preSum += num;

            // trick -> this is to add 1 to result when preSum == k
            //          this is alternative implementation for map.put(0, 1);

            // if (preSum == k) result++;

            result += map.getOrDefault(preSum - k, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return result;
    }
}

