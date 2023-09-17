class Solution {
    public int[] sortedSquares(int[] nums) {
        // trick -> fill the reuslt from the biggest number to the smallest number
        int left = 0;
        int right = nums.length - 1;

        int[] results = new int[nums.length];
        int index = results.length - 1;

        while (left <= right) {
            int value = nums[left] * nums[left];
            int value2 = nums[right] * nums[right];

            if (value > value2) {
                results[index--] = value;
                left++;
            } else {
                results[index--] = value2;
                right--;
            }
        }

        return results;
    }
}