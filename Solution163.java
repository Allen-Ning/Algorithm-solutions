public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        // trick -> this is to avoid overflow
        long lLower = (long) lower;
        long hUpper = (long) upper;

        List<String> list = new ArrayList();
        if (nums.length == 0)  {
            helper(list, lLower - 1, hUpper + 1);
            return list;
        }

        helper(list, lLower - 1, nums[0]);
        int i = 0;
        while (i < nums.length - 1) {
            int current = nums[i];
            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) current = nums[++i];
            if (i + 1 < nums.length) helper(list, current, nums[i + 1]);
            i++;
        }
        helper(list, nums[nums.length - 1], hUpper + 1);
        return list;
    }

    // trick -> helper will include [current + 1, next - 1]
    private void helper(List<String> list, long current, long next) {
        if (current + 2 < next) {
             list.add((current + 1) + "->" + (next - 1));
        } else if (current + 2 == next) {
            list.add(String.valueOf(current + 1));
        }
    }
}
