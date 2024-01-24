class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList();
        helper(results, new ArrayList(), candidates, target, 0);
        return results;
    }

    private void helper(List<List<Integer>> results, List<Integer> result, int[] candidates, int target, int index) {
        if (target < 0) return;
        if (target == 0) {
            results.add(new ArrayList(result));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            result.add(candidates[i]);
            // trick -> pass current i to avoid duplication
            //
            //   e.g.  [2, 3, 6, 7]
            //
            //       2            3           6            7
            //    2 3 6 7       3 6 7       6   7          7

            helper(results, result, candidates, target - candidates[i], i);
            result.remove(result.size() - 1);
        }
    }
}