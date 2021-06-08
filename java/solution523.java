class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // 7  / 6 = 1
        // 13 / 6 = 1
        int preSum = 0;
        HashMap<Integer, Integer> map = new HashMap();
        // trick -> this is very trick to avoid special case like 
        // [-1 ,1] 0, 
        // [0, 0] 0
        // [1, 8] 3

        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            int key = preSum;
            if (k != 0) {
                key = preSum % k;
            }

            if (map.containsKey(key)) {
                if (i - map.get(key) > 1) return true;
            } else {
                map.put(key, i);
            }
        }
        return false;
    }
}
