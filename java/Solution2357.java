class Solution {
    // time-complexity: o(n)
    public int minimumOperations(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for (int num : nums) {
            if (num == 0) continue;
            set.add(num);
        }
        return set.size();
    }

    // time-complexity: o(nlog(n))
    public int minimumOperations(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for (int num : nums) {
            if (num == 0) continue;
            set.add(num);
        }
        return set.size();
    }
} 