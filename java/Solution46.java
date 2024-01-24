class Solution {
    public List<List<Integer>> permute(int[] nums) {
        /**
            d f s - visitedSet
            [1, 2, 3]

                1          2         3
              2   3      1   3     1   2
             3     2    3     1   2      1
         */
        List<List<Integer>> results = new ArrayList();
        helper(results, new ArrayList(), nums, new boolean[nums.length]);
        return results;
    }

    private void helper(List<List<Integer>> results, List<Integer> result, int[] nums, boolean[] isVisited) {
        if (result.size() == nums.length) {
            results.add(new ArrayList(result));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i]) continue;

            result.add(nums[i]);
            isVisited[i] = true;
            helper(results, result, nums, isVisited);
            isVisited[i] = false;
            result.remove(result.size() - 1);
        }
    }
}