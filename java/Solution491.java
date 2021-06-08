class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> results = new ArrayList();
        List<Integer> result = new ArrayList<Integer>();
        helper(nums, 0, results, result);
        return results;
    }

    private void helper(int[] nums, int index, List<List<Integer>> results, List<Integer> result) {
        if (result.size() > 1) results.add(new ArrayList(result));

        HashSet<Integer> set = new HashSet();
        for (int i = index; i < nums.length; i++)  {
            if (set.contains(nums[i])) continue;
            if (index == 0 || (nums[index - 1] <= nums[i])) {
                set.add(nums[i]);
                result.add(nums[i]);
                helper(nums, i + 1, results, result);
                result.remove(result.size() - 1);
            }
        }
        return;
    }
}
