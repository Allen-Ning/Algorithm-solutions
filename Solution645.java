class Solution {
    //  [1,  2, 2,   4] values
    //  [0,  1, 1,   3] index
    //  [-1, -2, 2, -4]

    //  [2, 2]
    //  [1, 1]
    //  [2, -2
    public int[] findErrorNums(int[] nums) {
        int[] results = new int[2];
        if (nums == null || nums.length == 0) return results;
        for (int num : nums) {
            int absNum = Math.abs(num);
            int index = absNum - 1;
            if ((nums[index]) > 0) {
                nums[index] *= -1;
            } else {
                results[0] = absNum;
            }
        }

        for (int index = 0; index < nums.length; index++) {
            if (nums[index] < 0) continue;
            results[1] = index + 1;
            break;
        }
        return results;
    }
}
