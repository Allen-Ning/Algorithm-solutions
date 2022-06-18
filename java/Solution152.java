class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];

        int max = nums[0];
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            // trick -> swop min and max if num is negative
            //          e.g.
            //              case1: -2 * 24  (max)
            //                          12  (min)
            //              case2: -2 * 12  (max)
            //                          -2  (min)
            //              case3: -2 * -2  (max)
            //                          -12 (min)
            if (num < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(num, num * max);
            min = Math.min(num, num * min);

            result = Math.max(result, max);
        }
        return result;
    }
}