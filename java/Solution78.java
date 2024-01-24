class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList();
        helper(results, new ArrayList<Integer>(), nums, 0);
        return results;
    }

    private void helper(List<List<Integer>> results, List<Integer> result, int[] nums, int start) {
        results.add(new ArrayList<Integer>(result));

        for (int i = start; i < nums.length; i++) {
            result.add(nums[i]);
            helper(results, result, nums, i + 1);
            result.remove(result.size() - 1);
        }
    }
}