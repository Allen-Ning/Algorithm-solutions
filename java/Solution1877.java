class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;
        int result = 0;
        // trick -> min < a1 < a2 < max
        //          (min, a1), (a2, max)
        //          (min, a2), (a1, max)
        //          (min, max), (a1, a2) is the smallest maximum pair sum
        //       -> min < a1 < a2 < a3 < a4 < max could get the same result by using the
        //          the above conclusion after pick the first pair
        //          |(max, a1)|  (min, a4) |(a2, a3)|
        //          |(max, a2)|  (min, a4)  (a1, a3)
        //          |(max, a3)|  (min, a4)  (a1, a2)
        //          |(max, a4)|  x x x x
        //           (max, min)  (a1, a4)   (a2, a3)
        //          |()| indicates the potential maximum pair sum
        while (i < j) {
            result = Math.max(result, nums[i] + nums[j]);
            i++;
            j--;
        }
        return result;
    }
}