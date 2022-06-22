class Solution {
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

