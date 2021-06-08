class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        boolean[] isVisited = new boolean[nums.length];
        int total = 0;
        for (int num : nums) total += num;
        int targetValue = total / k;
        if (total % k != 0) return false;
        return helper(nums, isVisited, targetValue, 0, 0, k);
    }

    // trick -> this dfs is not easy to implement
    // notice: be careful the multiple return
    private boolean helper(int[] nums, boolean[] isVisited, int targetValue, int currentValue, int start, int k) {
        if (currentValue > targetValue) return false;
        if (k == 0) return true;

        // trick -> this is one of the most elegant and important part of this code
        if (currentValue == targetValue) return helper(nums, isVisited, targetValue, 0, 0, k - 1);

        // trick -> we need start to fix the element check one by one
        // [4, 3, 2, 3, 5, 2, 1]
        // head will check one by one
        for (int i = start; i < nums.length; i++) {
            if (isVisited[i]) continue;
            isVisited[i] = true;

            // trick -> only find a valid set and return to avoid mark multiple valid set
            if (helper(nums, isVisited, targetValue, nums[i] + currentValue, i + 1, k)) return true; 
            isVisited[i] = false;
        }
        return false;
    }
}
