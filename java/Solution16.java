class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 1; i++) {
            int value = target - nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end) {
                int sum = nums[start] + nums[end];
                if (sum == value) {
                    return target;
                } else if (sum < value) {
                    start++;    
                } else {
                    end--;
                }
                int currentResult = sum + nums[i];
                result = updateResult(target, currentResult, result);
            }
        }
        return result;
    }

    private int updateResult(int target, int currentResult, int result) {
        if (Math.abs(currentResult - target) < Math.abs(result - target)) result = currentResult;
        return result;
    }
}
