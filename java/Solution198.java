class Solution {
    public int rob(int[] nums) {
        int[] rob = new int[nums.length];
        int[] notRob = new int[nums.length];
        rob[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            rob[i] = notRob[i - 1] + nums[i];
            // trick ->  [2, 1, 1,           2]
            //         r  2  1  3            4
            //         n  0  2  2 max(1, 2)  3
            notRob[i] = Math.max(rob[i - 1], notRob[i - 1]);
        }
        return Math.max(rob[nums.length - 1], notRob[nums.length - 1]);
    }
}