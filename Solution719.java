class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int max = nums[nums.length - 1] - nums[0];
        for (int i = 1; i < nums.length; i++) min = Math.min(min, nums[i] - nums[i - 1]);
        // trick -> low bound
        while (min < max) {
            int mid = min + (max - min) / 2;
            int counter = getCounter(nums, mid);
            if (counter >= k) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    private int getCounter(int[] nums, int gap) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = findIndex(nums, i, nums[i] + gap);
            counter += index - i;
        }
        return counter;
    }

    private int findIndex(int[] nums, int start, int value) {
        int l = start;
        int r = nums.length;
        // trick -> upper bound
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > value) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return (l >= nums.length || nums[l] > value) ? l - 1 : l;
    }
}
