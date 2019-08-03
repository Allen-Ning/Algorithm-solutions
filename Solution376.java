class Solution {
    // [1,   2,  3, 4,  5,   6,  7,  8, 9]
    //  nil  +   +  + . +    + . + . + .+
    //  1    2   1  1   1    1   1   1  1
        
    // [1,   17,  5,  10,  13,  15, 10, 5, 16, 8]
    //  nil  +   -    +    +    +   -   -  +   -    
    //  1    2   3 .  4 .  1    1   1   5  6   7     

    // [3,  3,  3,  2,  5]
    // nil  nil nil -   +
    //  1   1   1
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = dp[0];
        boolean shouldBePostive = true;
        boolean locked = false;
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] - nums[i - 1]) == 0) {
                dp[i] = 1; 
                continue;
            }

            boolean isPositve = ((nums[i] - nums[i - 1]) > 0);
            if (locked && isPositve == shouldBePostive) {
                shouldBePostive = !shouldBePostive;
                dp[i] = max + 1;
            } else if (!locked) {
                shouldBePostive = !isPositve;
                dp[i] = dp[i - 1] + 1;
                locked = true;
            } else {
                dp[i] = 1;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
