class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) return 0;

        HashMap<Integer, Integer> map = new HashMap();
        int count = 0;
        for (int num : nums) {
            int value = map.getOrDefault(num, 0) + 1;
            if (value == 2) count++;
            map.put(num, value);
        }

        if (k == 0) return count;
        count = 0;

        for (Map.Entry<Integer, Integer> each : map.entrySet()) {
            int num = each.getKey();
            if (map.containsKey(num + k)) count++;
        }
        return count;
    }
}
