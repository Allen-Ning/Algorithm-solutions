public class Solution {
    // *  |-----*------|  *
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        TreeSet<Integer> values = new TreeSet<>();
        for (int index = 0; index < nums.length; index++) {
            Integer floor = values.floor(nums[index]);
            Integer ceil = values.ceiling(nums[index]);
            long value = Long.valueOf(nums[index]);
            if ((floor != null && Math.abs(value - Long.valueOf(floor)) <= t) || (ceil != null && Math.abs(value - Long.valueOf(ceil)) <= t)) {
                return true;
            }

            values.add(nums[index]);
            if (index >= k) {
                values.remove(nums[index - k]);
            }
        }

        return false;
    }
}
