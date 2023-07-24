class Solution {
    public int singleNumber(int[] nums) {
        // trick -> A ^ B ^ C ^ C ^ B = A
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}