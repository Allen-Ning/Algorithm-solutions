class Solution {
    public int minimumSwaps(int[] nums) {
        // trick -> set both of the maxIndex and minIndex are 0 to avoid extra check
        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (num >= nums[maxIndex]) maxIndex = i;
    

            if (num < nums[minIndex]) minIndex = i;
        }

        if (maxIndex == minIndex) {
            return 0;
        } else if (maxIndex > minIndex) {
            return nums.length - 1 - maxIndex + minIndex;
        } else {
            return nums.length - 1 - maxIndex + minIndex - 1;
        }
    }
}