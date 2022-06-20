class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList();
        helper(nums, 0, results, new ArrayList());
        return results;
    }

    private void helper(int[] nums, int index, List<List<Integer>> results, List<Integer> result) {
        List<Integer> clone = new ArrayList();
        for (Integer num : result) clone.add(num);
        results.add(clone);

        if (index >= nums.length) return;

        for (int i = index; i < nums.length; i++) {
            result.add(nums[i]);
            helper(nums, i + 1, results, result);
            result.remove(result.size() - 1);
        }
    }
}