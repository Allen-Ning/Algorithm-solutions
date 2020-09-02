public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();

        // trick -> we need to set (0, -1) means the intial sum is zero 
        //  -1   0   1  2   3  4 
        //   0  [1, -1, 5, -2, 3], k = 2
        //   0   1   0  5   3  6
        int preSum = 0;
        map.put(0, -1);
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (map.containsKey(preSum - k)) result = Math.max(result, i - map.get(preSum - k));
            // trick -> we only need to seach for  the maximum length of a subarray
            if (!map.containsKey(preSum)) map.put(preSum, i);
        }
        return result;
    }
}
