class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0) return 0; 
        int localMax = Integer.MIN_VALUE;

        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            localMax = Math.max(localMax, nums[i]);
            // trick -> rangeMax is local max
            // it get the right-most value, which is less than local max (to fnd deascending order)
            if (nums[i] < rangeMax) end = i;
        }

        int localMin = Integer.MAX_VALUE;
        int start = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            localMin = Math.min(localMin, nums[i]);
            // trick -> rangeMax is local min
            // it get the left-most value, which is greater than local min (to find deascending order)
            if (nums[i] > localMin) start = i;
        }

        // when end = 0; ascending order
        return end == 0 ? 0 : end - start + 1;
    }
}
