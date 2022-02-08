class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);

        // trick -> total +6
        // [3, 2, 1, 2, 1, 7]
        // [1, 1, 2, 2, 3, 7] after sort
        // [1, 2, 2, 2, 3, 7] +1
        // [1, 2, 3, 2, 3, 7] +1
        // [1, 2, 3, 4, 3, 7] +2
        // [1, 2, 3, 4, 6, 7] +3

        int prev = nums[0];
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            if (current <= prev) {
                int increment = (prev - current + 1);
                current += increment;
                result += increment;
            }
            prev = current;
        }
        return result;
    }
}