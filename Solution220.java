class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0) return false;

        // find min value
        int min = Integer.MAX_VALUE;
        for (int num : nums) min = Math.min(min, num);

        HashMap<Long, Long> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            long value = Long.valueOf(nums[i]);
            long key = (value -  Long.valueOf(min)) / (Math.abs(Long.valueOf(t)) + 1);
            if (map.containsKey(key) && Math.abs(map.get(key) - value) <= t) return true;
            if (map.containsKey(key - 1) && Math.abs(map.get(key - 1) - value) <= t) return true;
            if (map.containsKey(key + 1) && Math.abs(map.get(key + 1) - value) <= t) return true;
            map.put(key, value);

            if (i >= k) {
                map.remove((Long.valueOf(nums[i - k]) - min) / (Math.abs(Long.valueOf(t)) + 1));
            }
        }
        return false;
    }
}
