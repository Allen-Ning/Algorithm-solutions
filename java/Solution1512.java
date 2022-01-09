class Solution {
    public int numIdenticalPairs(int[] nums) {
        int result = 0;
        if (nums.length == 0) return result;

        int[] counters = new int[101];
        // trick -> this could avoid calculate An(2)
        for (int num : nums) {
            result += counters[num];
            counters[num]++;
        }
        return result;
    }
}